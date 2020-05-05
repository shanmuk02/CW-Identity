package cw.identity.data;

import cw.identity.data.model.User;

public class CustomUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	public CustomUser(User user) {
		super(user.getUsername(), user.getPassword(), user.getGrantedAuthoritiesList());
	}

}
