package eCommerceSystem.business.concretes;

import eCommerceSystem.business.abstracts.AuthService;
import eCommerceSystem.business.abstracts.UserService;
import eCommerceSystem.core.utils.Utils;
import eCommerceSystem.entities.concretes.LoginDto;
import eCommerceSystem.entities.concretes.User;

public class AuthManager implements AuthService {

	private UserService userService;

	public AuthManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public void register(User user) {
		if (userValidate(user) && passwordValidate(user.getPassword()) && userExists(user.geteMail()) == false
				&& Utils.emailValidate(user.geteMail())) {

			userService.add(user);

		} else {
			System.out.println("Kay�t ba�ar�s�z");
		}
	}

	@Override
	public void verify(User user, String token) {
		if (user != null && token.length() > 20) {
			User exitsUser = userService.get(user.geteMail());
			exitsUser.setVerify(true);

			userService.update(exitsUser);
			System.out.println("Do�ruland�");
		} else {
			System.out.println("Do�rulanamad�");
		}
	}

	@Override
	public boolean userExists(String email) {
		User user = userService.get(email);

		if (user == null) {
			return false;
		} else {
			System.out.println("Email mevcut." + email);
			return true;
		}
		
	}

	@Override
	public void login(LoginDto dto) {
		User user = userService.get(dto.getEmail());

		if (user != null && user.getPassword().equals(dto.getPassword())) {
			
			System.out.println("Ba�ar�yla giri� yapt�n�z.");

		}else {
			System.out.println("Kullan�c� ad� veya �ifre yanl��.");
		}
		

	}

	public boolean userValidate(User user) {
		if (user != null && !user.getFirstName().isEmpty() && !user.getLastName().isEmpty()
				&& !user.geteMail().isEmpty() && !user.getPassword().isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean passwordValidate(String password) {

		if (password.length() >= 6) {
			return true;
		} else {
			System.out.println("�ifreniz en az 6 karakter olmal�");
			return false;
		}
	}

}

