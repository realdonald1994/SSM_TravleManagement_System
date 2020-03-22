package cn.itcast.ssm.service;

import cn.itcast.ssm.domain.SysLog;

import java.util.List;

/**
 * application layer interface
 * sysLog
 */

public interface SysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(Integer page,Integer size) throws Exception;
}
