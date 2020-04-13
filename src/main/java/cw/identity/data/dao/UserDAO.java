package cw.identity.data.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import cw.identity.data.model.User;

@Repository
public class UserDAO {
	
	@Autowired private JdbcTemplate jdbcTemplate;
	
	public User getUserDetails(String username) {
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		//String encodedString = new String(Base64.encodeBase64(originalInput.getBytes()));
				
		List<User> userList =  jdbcTemplate.query("SELECT * FROM ad_user WHERE USERNAME=?", 
				new String[] { username }, (ResultSet rs, int rowNum) -> {
		User userRS = new User();
		userRS.setId(rs.getString("AD_User_ID"));
		userRS.setFirstname(rs.getString("firstname"));
		userRS.setLastname(rs.getString("lastname"));
		userRS.setName(rs.getString("name"));
		userRS.setUsername(rs.getString("username"));
		userRS.setPassword(rs.getString("password"));
		return userRS;
		});

		if (userList != null && userList.size() > 0) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
			grantedAuthoritiesList.add(grantedAuthority);
			userList.get(0).setGrantedAuthoritiesList(grantedAuthoritiesList);
			return userList.get(0);
		}

		return null;
	}
}
