package be.technifutur.spring.demo.validation.contraints;


import be.technifutur.spring.demo.validation.validators.BeforeDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = BeforeDateValidator.class)
public @interface BeforeDate {

    String message() default "Dates are not correct";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
