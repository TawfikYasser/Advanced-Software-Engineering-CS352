package main;

public class Notification {

	String subject, content, language, channel, placeholder, inputs;

	public Notification() {
	}

	public Notification(String subject, String content, String language, String channel, String placeholder,
			String inputs) {
		super();
		this.subject = subject;
		this.content = content;
		this.language = language;
		this.channel = channel;
		this.placeholder = placeholder;
		this.inputs = inputs;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}

	public String getInputs() {
		return inputs;
	}

	public void setInputs(String inputs) {
		this.inputs = inputs;
	}

}
