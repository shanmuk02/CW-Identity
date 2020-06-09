package cw.identity.config;

public class CWIdentity {
	
	private static String clientId;
	private static String username;
	private static String userId;
	private static String token;
	private static String applicationId;
	private static int sessionMaxInteractiveTime;
		
	public static String getClientId() {
		return clientId;
	}
	
	public static void setClientId(String clientId) {
		CWIdentity.clientId = clientId;
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
	
//	public static String getStringFromPOJO(Object object) {
//		// Get (JSON)String from Object
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		try {
//			String json = mapper.writeValueAsString(object);
//			return json;
//		} catch (JsonProcessingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "";
//		}
//	}
	
}
