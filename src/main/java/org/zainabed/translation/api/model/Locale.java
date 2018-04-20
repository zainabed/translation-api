package org.zainabed.translation.api.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Locale extends BaseModel {

	@NotNull
	@Size(min=5, max=20)
	private String name;

	@NotNull
	@Size(min = 5, max = 6)
	private String code;
	private Boolean defualt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getDefualt() {
		return defualt;
	}

	public void setDefualt(Boolean defualt) {
		this.defualt = defualt;
	}

}
