import java.util.ArrayList;


public class Notification {

	
	String subject, content, language, channel;
	ArrayList<Notification> notifications = new ArrayList<Notification>();


	public Notification(String subject, String content, String language, String channel) {
		super();
		this.subject = subject;
		this.content = content;
		this.language = language;
		this.channel = channel;
	}

	public Notification() {
		
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
	
	
	
}
