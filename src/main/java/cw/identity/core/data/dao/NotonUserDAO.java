package cw.identity.core.data.dao;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cw.identity.core.data.model.NotonUser;

@Repository
public class NotonUserDAO {
	
	private static final Logger log = LoggerFactory.getLogger(NotonUserDAO.class);
	@Autowired private MongoTemplate mongoTemplate;
	
	public NotonUser getUserDetails(String username) {
		NotonUser user = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(username));
			query.addCriteria(Criteria.where("isactive").is("Y"));
			user = mongoTemplate.findOne(query, NotonUser.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.error(e.getMessage(), e);
			return null;
		}

        return user;
	}
}
