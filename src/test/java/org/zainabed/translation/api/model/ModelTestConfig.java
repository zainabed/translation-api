package org.zainabed.translation.api.model;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.zainabed.translation.api.model.BaseModel;

public class ModelTestConfig {
	
	protected Validator validator;
	
	public ModelTestConfig(){
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	protected void verifyModel(BaseModel model, int constraintCount) {
		 Set<ConstraintViolation<BaseModel>> constraint = validator.validate(model);
		 assertEquals(constraintCount, constraint.size());
	}
}
