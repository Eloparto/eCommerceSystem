package eCommerceSystem.business.concretes;

import java.util.List;

import eCommerceSystem.core.EmailService;
import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class UserManager implements UserService {
	
	
	private UserDao userDao; 
	private EmailService emailService;
	public UserManager(UserDao userDao,EmailService emailService) {
		super();
		this.userDao = userDao;
		this.emailService=emailService;
	}

	@Override
	public void add(User user) {
		
		if(userValidate(user)) {
			userDao.add(user);
			
			emailService.send(user.geteMail(), "Kayýt Olundu");
		}
		
		
	}

	@Override
	public void update(User user) {
		if(userValidate(user)) {
			userDao.update(user);
		}
		
	}

	@Override
	public void delete(User userId) {
		userDao.delete(userId);
		
	}

	@Override
	public User get(String email) {
		
		return userDao.get(email);
	}

	@Override
	public List<User> getAll() {
		for (User user : userDao.getAll()) {
			System.out.println(user.getFirstName() + " "+ user.getLastName() + " "+ user.geteMail());
		}
		return userDao.getAll();
	}
	
	public boolean userValidate(User user) {
		
		if(user.getFirstName().length()>2 && user.getLastName().length()>2) {
			return true;
		}
		System.out.println("Ad ve soyad en az 2 karakter olmalýdýr.");
		return false;
	}

}