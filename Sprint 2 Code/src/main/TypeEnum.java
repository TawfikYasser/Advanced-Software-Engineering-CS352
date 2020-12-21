package main;

public enum TypeEnum {

	EMAIL, SMS, email, sms;
	
	
	public String toString() {

		switch (this) {
		case EMAIL:

		case email:
			return "Email";

		case SMS:

		case sms:
			return "Sms";

		default:
			return "Error";

		}
	}
	
}
