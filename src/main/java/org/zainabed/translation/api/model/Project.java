package org.zainabed.translation.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Project extends BaseModel {

	@NotNull
	@Size(min=5, max=15)
	private String name;
	
	@NotNull
	@Size(min=10, max=200)
	private String description;
	private String imageUri;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUri() {
		return imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

}
