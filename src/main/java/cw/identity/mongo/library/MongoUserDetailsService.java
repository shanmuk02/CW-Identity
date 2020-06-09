package cw.identity.mongo.library;

import cw.identity.config.CWIdentity;
import cw.identity.core.data.CustomUser;
import cw.identity.core.data.dao.UserDAO;
import cw.identity.core.data.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class MongoUserDetailsService implements UserDetailsService {

	@Autowired private UserDAO userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
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
		
//        Query query = new Query();
//        query.addCriteria(Criteria.where("username").is(username));
//        MongoUser user =
//                mongoTemplate.findOne(query, MongoUser.class);
//        if (user == null) {
//            throw new UsernameNotFoundException(String.format("Username %s not found", username));
//        }
//
//        String[] roles = new String[user.getRoles().size()];
//
//        return new User(user.getUsername(), user.getPassword(),
//                AuthorityUtils.createAuthorityList(user.getRoles().toArray(roles)));
    }
}