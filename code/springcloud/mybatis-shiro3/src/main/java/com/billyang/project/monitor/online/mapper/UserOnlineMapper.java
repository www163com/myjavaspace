package com.billyang.project.monitor.online.mapper;

import com.billyang.project.monitor.online.domain.UserOnline;

public interface UserOnlineMapper {
    /**
     * 通过会话序号查询信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public UserOnline selectOnlineById(String sessionId);
    /**
     * 通过会话序号删除信息
     * 
     * @param sessionId 会话ID
     * @return 在线用户信息
     */
    public int deleteOnlineById(String sessionId);
    /**
     * 保存会话信息
     * 
     * @param online 会话信息
     * @return 结果
     */
    public int saveOnline(UserOnline online);
}
