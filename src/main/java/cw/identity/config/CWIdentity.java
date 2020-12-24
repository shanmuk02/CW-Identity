package cw.identity.config;

public class CWIdentity {

	private static String clientId;
	private static String name;
	private static String username;
	private static String userId;
	private static String token;
	private static String applicationId;
	private static int sessionMaxInteractiveTime;
	private static String defaultCsRoleId;
	private static String defaultCsBunitId;
	private static String LocalIPAddress;
	private static String PublicIPAddress;
	private static String SystemInformation;
	private static String Browser;
	private static String BrowserVersion;
	
	public static String getClientId() {
		return clientId;
	}

	public static void setClientId(String clientId) {
		CWIdentity.clientId = clientId;
	}

	public static String getName() {
		return name;
	}

	public static void setName(String name) {
		CWIdentity.name = name;
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

	public static String getDefaultCsRoleId() {
		return defaultCsRoleId;
	}

	public static void setDefaultCsRoleId(String defaultCsRoleId) {
		CWIdentity.defaultCsRoleId = defaultCsRoleId;
	}

	public static String getDefaultCsBunitId() {
		return defaultCsBunitId;
	}

	public static void setDefaultCsBunitId(String defaultCsBunitId) {
		CWIdentity.defaultCsBunitId = defaultCsBunitId;
	}

	public static String getLocalIPAddress() {
		return LocalIPAddress;
	}

	public static void setLocalIPAddress(String localIPAddress) {
		LocalIPAddress = localIPAddress;
	}

	public static String getPublicIPAddress() {
		return PublicIPAddress;
	}

	public static void setPublicIPAddress(String publicIPAddress) {
		PublicIPAddress = publicIPAddress;
	}

	public static String getSystemInformation() {
		return SystemInformation;
	}

	public static void setSystemInformation(String systemInformation) {
		SystemInformation = systemInformation;
	}

	public static String getBrowser() {
		return Browser;
	}

	public static void setBrowser(String browser) {
		Browser = browser;
	}

	public static String getBrowserVersion() {
		return BrowserVersion;
	}

	public static void setBrowserVersion(String browserVersion) {
		BrowserVersion = browserVersion;
	}

}
