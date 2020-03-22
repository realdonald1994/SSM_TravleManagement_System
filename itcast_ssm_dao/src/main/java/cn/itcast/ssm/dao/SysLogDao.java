package cn.itcast.ssm.dao;

import cn.itcast.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * data layer LogDao
 */
@Repository
public interface SysLogDao {
    /**
     * save a log
     * @param sysLog
     * @throws Exception
     */
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(SysLog sysLog) throws Exception;

    /**
     * search all logs
     * @return
     */
    @Select("select * from syslog")
    List<SysLog> findAll() throws Exception;
}
