package cw.identity.redis.config;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.data.redis.core.RedisTemplate;

import cw.identity.config.CWIdentity;
import cw.identity.redis.data.model.Session;

public class CWRedis {

	private static RedisTemplate<Object, Object> redisTemplate;
	private static final String KEY = "token";
	
	public static RedisTemplate<Object, Object> getRedisTemplate() {
		return redisTemplate;
	}
	
	public static void setRedisTemplate(RedisTemplate<Object, Object> redistemplate) {
		CWRedis.redisTemplate = redistemplate;
	}
	
//	public static void insertTokenToRedis1() {
//		try {
//			Optional<Session> optionalSession = sessionDao.findById(CWIdentity.getToken()); 
//			Session session = optionalSession.isPresent() ? optionalSession.get() : null;
//
//			if(session==null) {
//				session = new Session(CWIdentity.getToken(), CWIdentity.getUserId(), CWIdentity.getUsername(), 
//						CWIdentity.getClientId(), CWIdentity.getApplicationId(), "", new Date(), 
//						new Date(), CWIdentity.getSessionMaxInteractiveTime());
//			} else {
//				session.setLastAccessTime(new Date());
//			}
//			
//			sessionDao.save(session);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			System.err.println("Error in insertTokenToRedis Process");
//			e.printStackTrace();
//		}
//	}
	
	@SuppressWarnings("rawtypes")
	public static void insertTokenToRedis() {
		try {
			Session session = getSession(CWIdentity.getToken());
			if(session==null) {
				session = new Session(CWIdentity.getToken(), CWIdentity.getUserId(), CWIdentity.getUsername(), 
						CWIdentity.getClientId(), CWIdentity.getApplicationId(), "", new Date(), 
						new Date(), CWIdentity.getSessionMaxInteractiveTime());
			} else {
				session.setLastAccessTime(new Date());
			}
			
			Map ruleHash = new ObjectMapper().convertValue(session, Map.class);
			redisTemplate.opsForHash().put(KEY, session.getToken(), ruleHash);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	@SuppressWarnings("rawtypes")
	public static Session getSession(String token) {
		Map sessionMap = (Map) redisTemplate.opsForHash().get(KEY, token);
        return (new ObjectMapper().convertValue(sessionMap, Session.class));
	}

}
