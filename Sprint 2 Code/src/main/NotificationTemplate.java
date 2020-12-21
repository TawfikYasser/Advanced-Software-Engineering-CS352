package main;

public class NotificationTemplate {

	
	String templateSubject, templateContent, templatePlaceholders, templateInputs;
	LanguageEnum templateLanguage;
	TypeEnum templateType;
	
	public NotificationTemplate() {
		// TODO Auto-generated constructor stub
	}
	

	public NotificationTemplate(String templateSubject, String templateContent,
			String templatePlaceholders, String templateInputs, LanguageEnum templateLanguage, TypeEnum templateType) {
		super();
		this.templateSubject = templateSubject;
		this.templateContent = templateContent;
		this.templatePlaceholders = templatePlaceholders;
		this.templateInputs = templateInputs;
		this.templateLanguage = templateLanguage;
		this.templateType = templateType;
	}



	public String getTemplateSubject() {
		return templateSubject;
	}

	public void setTemplateSubject(String templateSubject) {
		this.templateSubject = templateSubject;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getTemplatePlaceholders() {
		return templatePlaceholders;
	}

	public void setTemplatePlaceholders(String templatePlaceholders) {
		this.templatePlaceholders = templatePlaceholders;
	}

	public String getTemplateInputs() {
		return templateInputs;
	}

	public void setTemplateInputs(String templateInputs) {
		this.templateInputs = templateInputs;
	}

	public LanguageEnum getTemplateLanguage() {
		return templateLanguage;
	}

	public void setTemplateLanguage(LanguageEnum templateLanguage) {
		this.templateLanguage = templateLanguage;
	}

	public TypeEnum getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TypeEnum templateType) {
		this.templateType = templateType;
	}

	
	
}
