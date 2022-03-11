package cw.identity.mongo.library.document;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "mongo_session_activity")
public class MongoSessionActivity {

	@Id
	@Field("_id")
	private String id;
	private String token;
	private int sequence;
	private Date lastAccessTime;

	public MongoSessionActivity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MongoSessionActivity(String id, String token, int sequence, Date lastAccessTime) {
		super();
		this.id = id;
		this.token = token;
		this.sequence = sequence;
		this.lastAccessTime = lastAccessTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	@Override
	public String toString() {
		return "MongoSessionActivity [id=" + id + ", token=" + token + ", sequence=" + sequence + ", lastAccessTime="
				+ lastAccessTime + "]";
	}

}
