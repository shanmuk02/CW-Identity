package cw.identity.core.data.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "cs_user")
public class MongoUser {

	@Id
	private ObjectId id;
	@Field(name = "cs_user_id")
	private String csUserId;
	@Field(name = "firstname")
	private String firstname;
	@Field(name = "lastname")
	private String lastname;
	@Field(name = "name")
	private String name;
	@Field(name = "password")
	private String password;
	@Field(name = "email")
	private String email;
	@Field(name = "description")
	private String description;
	@Field(name = "username")
	private String username;
	@Field(name = "cs_window_id")
	private String csWindowId;
	@Field(name = "created")
	private String created;
	@Field(name = "createdby")
	private String createdby;
	@Field(name = "cs_bunit_id")
	private String csBunitId;
	@Field(name = "cs_client_id")
	private String csClientId;
	@Field(name = "isactive")
	private String isactive;
	@Field(name = "updated")
	private String updated;
	@Field(name = "updatedby")
	private String updatedby;
	@Field(name = "defaultCsRoleId")
	private String defaultCsRoleId;
	@Field(name = "defaultCsBunitId")
	private String defaultCsBunitId;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getCsUserId() {
		return csUserId;
	}

	public void setCsUserId(String csUserId) {
		this.csUserId = csUserId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCsWindowId() {
		return csWindowId;
	}

	public void setCsWindowId(String csWindowId) {
		this.csWindowId = csWindowId;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	public String getCsBunitId() {
		return csBunitId;
	}

	public void setCsBunitId(String csBunitId) {
		this.csBunitId = csBunitId;
	}

	public String getCsClientId() {
		return csClientId;
	}

	public void setCsClientId(String csClientId) {
		this.csClientId = csClientId;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public String getUpdated() {
		return updated;
	}

	public void setUpdated(String updated) {
		this.updated = updated;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public String getDefaultCsRoleId() {
		return defaultCsRoleId;
	}

	public void setDefaultCsRoleId(String defaultCsRoleId) {
		this.defaultCsRoleId = defaultCsRoleId;
	}

	public String getDefaultCsBunitId() {
		return defaultCsBunitId;
	}

	public void setDefaultCsBunitId(String defaultCsBunitId) {
		this.defaultCsBunitId = defaultCsBunitId;
	}

}
