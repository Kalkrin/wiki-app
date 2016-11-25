package ca.sheridancollege.DAO;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.beans.User;
import ca.sheridancollege.beans.Wiki;

public class DAO {
	//Creating the session.
	SessionFactory sessionFactory= new Configuration().configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public void saveWiki(Wiki wiki){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		//Saving the values passed into this method using the object department into the database
		session.saveOrUpdate(wiki);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Wiki> getWiki(){
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Wiki.class);
		
		List<Wiki> wikiList = (List<Wiki>)criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return wikiList;
	}
	
	public List<User> getUsers(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(User.class);
		
		List<User> userList = (List<User>)criteria.list();
		
		session.getTransaction().commit();
		session.close();
		return userList;
	}
	
	public void saveUser(User user){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		//Saving the values passed into this method using the object department into the database
		session.saveOrUpdate(user);
		
		session.getTransaction().commit();
		session.close();
	}
}


