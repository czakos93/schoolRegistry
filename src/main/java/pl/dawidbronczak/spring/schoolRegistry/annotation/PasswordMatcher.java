package pl.dawidbronczak.spring.schoolRegistry.annotation;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.dawidbronczak.spring.schoolRegistry.validator.PasswordMatcherValidator;

@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = PasswordMatcherValidator.class)
public @interface PasswordMatcher {
	String message() default "{pl.dawidbronczak.spring.schoolRegistry.PasswordMatcher.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
