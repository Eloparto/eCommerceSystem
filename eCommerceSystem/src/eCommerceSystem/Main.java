package eCommerceSystem;

import eCommerceSystem.business.concretes.AuthManager;
import eCommerceSystem.business.concretes.UserManager;
import eCommerceSystem.core.amazonEmail.AmazonMailManagerAdapter;
import eCommerceSystem.core.googleEmail.GoogleMailManagerAdapter;
import eCommerceSystem.dataAccess.concretes.InMemoryUserDao;
import eCommerceSystem.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		 
		
		InMemoryUserDao inMemoryUserDao=new InMemoryUserDao();
		AuthManager authManager=new AuthManager(new UserManager(inMemoryUserDao,new AmazonMailManagerAdapter()));
			
		User user=new User(4,"Andrew","Lincoln","andrew.lincoln@gmail.com","123456",true);
		
		authManager.register(user);
		
		UserManager userManager=new UserManager(inMemoryUserDao, new GoogleMailManagerAdapter());

		userManager.getAll();
		
		
	}
	
	
	
	

}
