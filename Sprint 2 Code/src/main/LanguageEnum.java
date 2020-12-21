package main;

public enum LanguageEnum {

	ARABIC, ENGLISH, arabic, english;

	public String toString() {

		switch (this) {
		case ARABIC:

		case arabic:
			return "Arabic";

		case ENGLISH:

		case english:
			return "English";

		default:
			return "Error";

		}
	}

}
