package cw.identity.data.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cw.identity.data.model.Session;

@Repository
public interface SessionDAO extends CrudRepository<Session, String> {

}
