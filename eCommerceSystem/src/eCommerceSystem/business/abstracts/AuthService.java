package eCommerceSystem.business.abstracts;

import eCommerceSystem.entities.concretes.LoginDto;
import eCommerceSystem.entities.concretes.User;

public interface AuthService {

	void register(User user);	
	void verify(User user,String token);	
	boolean userExists(String email);	
	void login(LoginDto dto);
	
}
