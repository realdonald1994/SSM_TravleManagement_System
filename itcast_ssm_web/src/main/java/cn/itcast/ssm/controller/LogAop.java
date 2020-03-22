package cn.itcast.ssm.controller;

import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    private Date visitTime;// start time
    private Class aClass;// Accessed classes
    private Method method;//Accessed methods

    /**
     * Before Advice -> log
     * write execution time, execution class, execution methods
     *
     * @param joinPoint
     */
    @Before("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();// start time
        aClass = joinPoint.getTarget().getClass();// accessed classes
        if (!aClass.getName().equals("cn.itcast.ssm.controller.SysLogController")) {
            String methodName = joinPoint.getSignature().getName();// accessed methods name
            Object[] args = joinPoint.getArgs();//arguments

            //get method object
            if (args == null || args.length == 0) {
                method = aClass.getMethod(methodName);// no argument method
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i] = args[i].getClass();
                }
                method = aClass.getMethod(methodName, classArgs);
            }
        }

    }

    /**
     * After advice->log
     *
     * @param joinPoint
     */
    @After("execution(* cn.itcast.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {

        long executionTime = new Date().getTime() - visitTime.getTime();//accessed time


        //url
        String url = "";
        if (aClass != null && method != null && aClass != LogAop.class) {
            //get RequestMapping of class
            RequestMapping classAnnotation = (RequestMapping) aClass.getAnnotation(RequestMapping.class);
            if (classAnnotation != null) {
                String classUrl = classAnnotation.value()[0];

                // get RequestMapping of method
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String methodUrl = methodAnnotation.value()[0];
                    url = classUrl + methodUrl;

                    //ip
                    String ip = request.getRemoteAddr();

                    //user
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();

                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(executionTime);
                    sysLog.setIp(ip);
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setMethod(aClass.getName() + "." + method.getName());
                    sysLog.setVisitTime(visitTime);

                    sysLogService.save(sysLog);
                }
            }

        }

    }
}
