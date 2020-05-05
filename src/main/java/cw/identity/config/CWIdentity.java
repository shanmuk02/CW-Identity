package cw.identity.config;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.redis.core.RedisTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import cw.identity.data.dao.SessionDAO;
import cw.identity.data.model.Session;

public class CWIdentity {
	
	private static RedisTemplate<String, String> redisTemplate;
	private static String username;
	private static String userId;
	private static String token;
	private static String applicationId;
	private static SessionDAO sessionDao;
	private static int sessionMaxInteractiveTime;
	
	public static SessionDAO getSessionDao() {
		return sessionDao;
	}

	public static void setSessionDao(SessionDAO sessionDao) {
		CWIdentity.sessionDao = sessionDao;
	}

	public static RedisTemplate<String, String> getRedisTemplate() {
		return redisTemplate;
	}
	
	public static void setRedisTemplate(RedisTemplate<String, String> redistemplate) {
		CWIdentity.redisTemplate = redistemplate;
	}
	
	public static String getUsername() {
		return username;
	}
	
	public static void setUsername(String username) {
		CWIdentity.username = username;
	}
	
	public static String getUserId() {
		return userId;
	}
	
	public static void setUserId(String userId) {
		CWIdentity.userId = userId;
	}

	public static String getToken() {
		return token;
	}

	public static void setToken(String token) {
		CWIdentity.token = token;
	}
	
	public static String getApplicationId() {
		return applicationId;
	}

	public static void setApplicationId(String applicationId) {
		CWIdentity.applicationId = applicationId;
	}
	
	public static int getSessionMaxInteractiveTime() {
		return sessionMaxInteractiveTime;
	}

	public static void setSessionMaxInteractiveTime(int sessionMaxInteractiveTime) {
		CWIdentity.sessionMaxInteractiveTime = sessionMaxInteractiveTime;
	}
	
	public static void insertTokenToRedis() {
		try {
			Optional<Session> optionalSession = sessionDao.findById(token); 
			Session session;
			if(!optionalSession.isPresent()) {
				session = new Session(token, userId, username, applicationId, "", new Date(), new Date(), sessionMaxInteractiveTime);
				sessionDao.save(session);
			} else {
				session = optionalSession.get();
				session.setLastAccessTime(new Date());
				sessionDao.save(session);
			}
			
//			if(redisTemplate.opsForHash().get("Session", token) == null) {
//				session = new Session(token, userId, username, "", "", new Date(), new Date());
//			} else {
//				String json = redisTemplate.opsForHash().get("Session", token).toString();
//				final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new GsonDateTypeAdapter()).create();
//				session = gson.fromJson(json, Session.class);
//				session.setLastAccessTime(new Date());
//			}
//			String json = getStringFromPOJO(session);
//			redisTemplate.opsForHash().put("Session", token, json);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Error in insertTokenToRedis Process");
			e.printStackTrace();
		}
	}

	public static String getStringFromPOJO(Object object) {
		// Get (JSON)String from Object
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String json = mapper.writeValueAsString(object);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
	
}
