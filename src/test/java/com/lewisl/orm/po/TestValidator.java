package com.lewisl.orm.po;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import static org.junit.Assert.*;

public class TestValidator {
	private static Logger logger = LoggerFactory.getLogger(TestValidator.class);
	private static Validator validator;

	@BeforeClass
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testEntity() {
		logger.info("Start to test Validator");

		Class cls = new Class();

		Student stu = new Student();
		stu.setSid(-222);
		stu.setName("Lewisl");
		stu.setCls(cls);

		Set<ConstraintViolation<Student>> violations = validator.validate(stu);

		// assertTrue(violations.isEmpty());
		ConstraintViolation<Student> vila = null;
		if (!violations.isEmpty()) {
			for (Iterator<ConstraintViolation<Student>> ite = violations
					.iterator(); ite.hasNext();) {
				vila = ite.next();
				logger.info(vila.getRootBean().toString());
				logger.info(vila.getLeafBean().toString());
				logger.info(vila.getMessageTemplate());
				logger.info((String) vila.getInvalidValue());
				logger.info(vila.getMessage());
			}
		}
		logger.info("End to test Validator");
	}
	
	@Test
	public void validateSingleProperty() {
		logger.info("Start to test Validator Single Property");


		Student stu = new Student();
		stu.setSid(-222);
//		stu.setName("Lewisl");
		Set<ConstraintViolation<Student>> violations = validator.validateProperty(stu,"name");

		// assertTrue(violations.isEmpty());
		ConstraintViolation<Student> vila = null;
		if (!violations.isEmpty()) {
			for (Iterator<ConstraintViolation<Student>> ite = violations
					.iterator(); ite.hasNext();) {
				vila = ite.next();
				logger.info(vila.getRootBean().toString());
				logger.info(vila.getLeafBean().toString());
				logger.info(vila.getMessageTemplate());
				logger.info((String) vila.getInvalidValue());
				logger.info(vila.getMessage());
			}
		}
		logger.info("End to test Validator Single Property");
	}
	
	
	@Test
	public void validateValue() {
		logger.info("Start to test Validator value");

		Student stu = new Student();
		stu.setSid(-222);
		stu.setName("Lewisl");
		Set<ConstraintViolation<Student>> violations = validator.validateValue(Student.class, "name","");

		// assertTrue(violations.isEmpty());
		ConstraintViolation<Student> vila = null;
		if (!violations.isEmpty()) {
			for (Iterator<ConstraintViolation<Student>> ite = violations
					.iterator(); ite.hasNext();) {
				vila = ite.next();
				logger.info(vila.getMessageTemplate());
				logger.info((String) vila.getInvalidValue());
				logger.info(vila.getMessage());
				logger.info(vila.getConstraintDescriptor().getAnnotation().toString());
			}
		}
		logger.info("End to test Validator value");
	}
}
