package com.lewisl.orm.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity(name = "Student")
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * Student Primary Key SID
	 */
	@Id
	// @NotBlank
	// @Range(min = 0)
	private Integer sid;

	/**
	 * The name of student
	 */
	@Column(name = "name")
	@NotBlank
	private String name;

	@Valid
	@NotNull
	private Class cls;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getCls() {
		return cls;
	}

	public void setCls(Class cls) {
		this.cls = cls;
	}

}
