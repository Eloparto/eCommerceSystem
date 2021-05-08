package eCommerceSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerceSystem.dataAccess.abstracts.UserDao;
import eCommerceSystem.entities.concretes.User;

public class InMemoryUserDao implements UserDao {
	
	private List<User> users=new ArrayList<User>();
	
	public InMemoryUserDao() {
		
		User user1=new User(1,"Kaðan","Eloparto","eloparto@google.com","123456",true);
		User user2=new User(2,"Elliot","Anderson","senpai@gmail.com","123456",true);
		User user3=new User(3,"Mr.","Robot","mr.robot@gmail.com","1234567",true);
		
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
	}

	@Override
	public void add(User user) {
		System.out.println("Kaydedildi : "+ user.geteMail());
		users.add(user);
		
		
	}

	@Override
	public void update(User user) {
		User userUpdate=users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(null);
		
		userUpdate.seteMail(user.geteMail());
		userUpdate.setFirstName(user.getFirstName());
		userUpdate.setLastName(user.getLastName());
		userUpdate.setPassword(user.getPassword());
		userUpdate.setVerify(user.isVerify());
	}

	@Override
	public void delete(User user) {
		User userToDelete=users.stream()
				.filter(u->u.getId()==user.getId())
				.findFirst()
				.orElse(null);
		users.remove(userToDelete);
		
	}

	@Override
	public List<User> getAll() {
		
		return users;
	}

	@Override
	public User get(String email) {
		User user=users.stream()
				.filter(u->u.geteMail()==email)
				.findFirst()
				.orElse(null);
		return user;
	}

}
