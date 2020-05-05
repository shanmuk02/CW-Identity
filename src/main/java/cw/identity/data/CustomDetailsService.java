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
		CustomUser customUser = null;
		try {
			User user = userDao.getUserDetails(username);
			if(user == null)
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			customUser = new CustomUser(user);
			CWIdentity.setUserId(user.getId());
			CWIdentity.setUsername(user.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		return customUser;
	}

}
