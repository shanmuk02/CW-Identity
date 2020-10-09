package cw.identity.core.data;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import cw.identity.core.data.model.MongoUser;

public class CustomMongoUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	public CustomMongoUser(MongoUser user) {
		super(user.getUsername(), user.getPassword(), getRoleList());
	}
	
	private static Collection<GrantedAuthority> getRoleList() {
		Collection<GrantedAuthority> grantedAuthoritiesList = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_SYSTEMADMIN");
		grantedAuthoritiesList.add(grantedAuthority);
		
		return grantedAuthoritiesList;
	}

}
