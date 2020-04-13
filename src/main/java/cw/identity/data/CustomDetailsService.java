package cw.identity.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cw.identity.config.CWIdentity;
import cw.identity.data.dao.UserDAO;
import cw.identity.data.model.User;

@Service
public class CustomDetailsService implements UserDetailsService {

	@Autowired private UserDAO userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDao.getUserDetails(username);
		CWIdentity.setUserId(user.getId());
		CWIdentity.setUsername(user.getName());
		return new CustomUser(user);
	}

}
