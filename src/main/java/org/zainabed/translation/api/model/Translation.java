package org.zainabed.translation.api.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Translation extends BaseModel {

	@NotNull
	private Key key;
	
	@NotNull
	private Locale locale;
	
	@NotNull
	private String content;
	private Boolean verified;

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Boolean getVerified() {
		return verified;
	}

	public void setVerified(Boolean verified) {
		this.verified = verified;
	}

}
