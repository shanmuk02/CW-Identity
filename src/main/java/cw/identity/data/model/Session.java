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
	private String applicationId;
	private String applicationSecret;
	private Date startTime;
	private Date lastAccessTime;
	
	public Session(String token, String userId, String name, String applicationId, String applicationSecret, Date startTime,
			Date lastAccessTime) {
		super();
		this.token = token;
		this.userId = userId;
		this.name = name;
		this.applicationId = applicationId;
		this.applicationSecret = applicationSecret;
		this.startTime = startTime;
		this.lastAccessTime = lastAccessTime;
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	@Override
	public String toString() {
		return "Session [userId=" + userId + ", name=" + name + ", applicationId=" + applicationId
				+ ", applicationSecret=" + applicationSecret + ", startTime=" + startTime + ", lastAccessTime="
				+ lastAccessTime + "]";
	}
	
	
	
	
}
