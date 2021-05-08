package eCommerceSystem.dataAccess.abstracts;

import java.util.List;

import eCommerceSystem.entities.concretes.User;

public interface UserDao {

	void add(User user);
	
	void update(User user);
	
	void delete(User id);
	
	List<User> getAll();
	
	User get(String eMail);
	
}
