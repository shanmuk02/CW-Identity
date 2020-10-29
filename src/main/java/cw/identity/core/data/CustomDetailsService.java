package cw.identity.core.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cw.identity.config.CWIdentity;
import cw.identity.core.data.model.MongoUser;
import cw.identity.core.data.model.User;
import cw.identity.core.data.dao.MongoUserDAO;
import cw.identity.core.data.dao.UserDAO;

// Class is used for UserDetails Service - REDIS

@Service
public class CustomDetailsService implements UserDetailsService {

	@Autowired private UserDAO userDao;
	@Autowired MongoUserDAO mongoUserDao;
	@Value("#{('${user.db}')}") private String userDB;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		if(userDB.equalsIgnoreCase("MONGO")) {
			// MONGO DB for userDetails
			CustomMongoUser customMongoUser = null;
			try {
				MongoUser user = mongoUserDao.getUserDetails(username);
				if(user == null)
					throw new UsernameNotFoundException("User " + username + " was not found in the database");

				customMongoUser = new CustomMongoUser(user);
				CWIdentity.setUserId(user.getCsUserId());
				CWIdentity.setUsername(user.getUsername());
				CWIdentity.setClientId(user.getCsClientId());
				CWIdentity.setName(user.getName());
				CWIdentity.setDefaultCsRoleId(user.getDefaultCsRoleId());
				CWIdentity.setDefaultCsBunitId(user.getDefaultCsBunitId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
			return customMongoUser;
		} else {
			// POSTGRES DB for userDetails
			CustomUser customUser = null;
			try {
				User user = userDao.getUserDetails(username);
				if(user == null)
					throw new UsernameNotFoundException("User " + username + " was not found in the database");
				customUser = new CustomUser(user);
				CWIdentity.setUserId(user.getId());
				CWIdentity.setUsername(user.getName());
				CWIdentity.setClientId(user.getAdClientId());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new UsernameNotFoundException("User " + username + " was not found in the database");
			}
			return customUser;
		}
	}
}
