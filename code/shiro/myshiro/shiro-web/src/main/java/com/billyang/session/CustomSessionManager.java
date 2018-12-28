package com.billyang.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * @author yangcan14944
 * @version V1.0
 * @Project myshiro
 * @Package com.billyang.session
 * @Description: ${todo}
 * @date 2018.12.28
 * @time 15:17
 */
public class CustomSessionManager extends DefaultWebSessionManager {
    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        if(sessionKey instanceof WebSessionKey){
            request = ((WebSessionKey)sessionKey).getServletRequest();
        }
        if(request != null && sessionId!=null){
            Session session= (Session) request.getAttribute(sessionId.toString());
            if(session!=null){
                return session;
            }
        }
        Session session = super.retrieveSession(sessionKey);
        if(request!=null && sessionId!=null){
            request.setAttribute(sessionId.toString(),session);
        }
        return session;
    }
}
