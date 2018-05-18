package pl.dawidbronczak.spring.schoolRegistry.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import pl.dawidbronczak.spring.schoolRegistry.annotation.PasswordMatcher;
import pl.dawidbronczak.spring.schoolRegistry.dto.UserDTO;

public class PasswordMatcherValidator implements ConstraintValidator<PasswordMatcher, UserDTO> {

	@Override
	public void initialize(PasswordMatcher constraint) {
		
	}
	
	@Override
	public boolean isValid(UserDTO form, ConstraintValidatorContext context) {
		return form.getPassword().equals(form.getPasswordConfirm());
	}

}
