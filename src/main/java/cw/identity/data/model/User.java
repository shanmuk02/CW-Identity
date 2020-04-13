package cw.identity.data.model;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Postgres Table - Ad_User
 * Purpose - to validate login credentials
 * */

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;

@Table(value = "ad_user")
public class User {

	@Id @Column(value = "ad_user_id")
	private String id;
	@Column(value = "username")
	private String username;
	@Column(value = "password")
	private String password;
	@Column(value = "firstname")
	private String firstname;
	@Column(value = "lastname")
	private String lastname;
	@Column(value = "name")
	private String name;
	private Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String id, String username, String password, String firstname, String lastname, String name,
			Collection<GrantedAuthority> grantedAuthoritiesList) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.name = name;
		this.grantedAuthoritiesList = grantedAuthoritiesList;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Collection<GrantedAuthority> getGrantedAuthoritiesList() {
		return grantedAuthoritiesList;
	}

	public void setGrantedAuthoritiesList(Collection<GrantedAuthority> grantedAuthoritiesList) {
		this.grantedAuthoritiesList = grantedAuthoritiesList;
	}

	
}
