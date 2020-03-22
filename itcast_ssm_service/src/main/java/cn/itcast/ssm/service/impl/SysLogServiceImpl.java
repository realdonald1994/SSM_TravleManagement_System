package cn.itcast.ssm.service.impl;

import cn.itcast.ssm.dao.SysLogDao;
import cn.itcast.ssm.domain.SysLog;
import cn.itcast.ssm.service.SysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * application layer: implementation
 * log service
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    private SysLogDao sysLogDao;

    /**
     * save log
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    /**
     * search all logs
     * @return
     * @throws Exception
     */
    @Override
    public List<SysLog> findAll(Integer page,Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
