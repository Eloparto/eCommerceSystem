package eCommerceSystem.core.amazonEmail;

import eCommerceSystem.amazonEmail.AmazonMailManager;
import eCommerceSystem.core.EmailService;

public class AmazonMailManagerAdapter implements EmailService {

	private AmazonMailManager amazonMailManager;
	
	public AmazonMailManagerAdapter() {

		this.amazonMailManager = new AmazonMailManager();
	}

	@Override
	public void send(String email, String message) {

		amazonMailManager.send(email, message);
		
	}

}
