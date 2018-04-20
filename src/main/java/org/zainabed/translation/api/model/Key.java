package org.zainabed.translation.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Key extends BaseModel {

	@NotNull
	@Size(min=5, max=30)
	private String name;
	
	@NotNull
	@Size(min=5, max=50)
	private String description;

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

}
