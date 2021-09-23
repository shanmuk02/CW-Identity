package cw.identity.mongo.library.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongo_session")
public class MongoSession {

	@Id
	private String id;
	private String token;
	private String userId;
	private String name;
	private String username;
	private String clientId;
	private String applicationId;
	private String applicationSecret;
	private Date creationTime;
	private Date lastAccessTime;
	private int maxInteractiveTime;
	private String roleId;
	private String bunitId;
	private String localIPAddress;
	private String publicIPAddress;
	private String systemInformation;
	private String browser;
	private String browserVersion;
	private String tillId;

	public MongoSession() {

	}

	public MongoSession(String id, String token, String userId, String name, String username, String clientId,
			String applicationId, String applicationSecret, Date creationTime, Date lastAccessTime,
			int maxInteractiveTime, String roleId, String bunitId, String localIPAddress, String publicIPAddress,
			String systemInformation, String browser, String browserVersion, String tillId) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.clientId = clientId;
		this.applicationId = applicationId;
		this.applicationSecret = applicationSecret;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.maxInteractiveTime = maxInteractiveTime;
		this.roleId = roleId;
		this.bunitId = bunitId;
		this.localIPAddress = localIPAddress;
		this.publicIPAddress = publicIPAddress;
		this.systemInformation = systemInformation;
		this.browser = browser;
		this.browserVersion = browserVersion;
		this.tillId = tillId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApplicationSecret() {
		return applicationSecret;
	}

	public void setApplicationSecret(String applicationSecret) {
		this.applicationSecret = applicationSecret;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	public int getMaxInteractiveTime() {
		return maxInteractiveTime;
	}

	public void setMaxInteractiveTime(int maxInteractiveTime) {
		this.maxInteractiveTime = maxInteractiveTime;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getBunitId() {
		return bunitId;
	}

	public void setBunitId(String bunitId) {
		this.bunitId = bunitId;
	}

	public String getLocalIPAddress() {
		return localIPAddress;
	}

	public void setLocalIPAddress(String localIPAddress) {
		this.localIPAddress = localIPAddress;
	}

	public String getPublicIPAddress() {
		return publicIPAddress;
	}

	public void setPublicIPAddress(String publicIPAddress) {
		this.publicIPAddress = publicIPAddress;
	}

	public String getSystemInformation() {
		return systemInformation;
	}

	public void setSystemInformation(String systemInformation) {
		this.systemInformation = systemInformation;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getBrowserVersion() {
		return browserVersion;
	}

	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}

	public String getTillId() {
		return tillId;
	}

	public void setTillId(String tillId) {
		this.tillId = tillId;
	}

}
