package com.lewisl.orm.po;

import org.hibernate.validator.constraints.NotBlank;

public class Class {
	@NotBlank
	private String className;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
