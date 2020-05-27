package cw.identity.data.model;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash(value = "Session")
public class Session {
	
	@Id @NotNull
	private String token;
	private String userId;
	private String name;
	private String clientId;
	private String applicationId;
	private String applicationSecret;
	private Date creationTime;
	private Date lastAccessTime;
	private int maxInteractiveTime;
	
	public Session(String token, String userId, String name, String clientId, String applicationId, String applicationSecret, Date creationTime,
			Date lastAccessTime, int maxInteractiveTime) {
		super();
		this.token = token;
		this.userId = userId;
		this.name = name;
		this.clientId = clientId;
		this.applicationId = applicationId;
		this.applicationSecret = applicationSecret;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.maxInteractiveTime = maxInteractiveTime;
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

	public Date getcreationTime() {
		return creationTime;
	}

	public void setcreationTime(Date creationTime) {
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

	@Override
	public String toString() {
		return "Session [userId=" + userId + ", name=" + name + ", applicationId=" + applicationId
				+ ", applicationSecret=" + applicationSecret + ", creationTime=" + creationTime + ", lastAccessTime="
				+ lastAccessTime + ", maxInteractiveTime=" + maxInteractiveTime + "]";
	}
	
}
