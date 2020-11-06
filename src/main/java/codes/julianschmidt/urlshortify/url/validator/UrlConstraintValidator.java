package codes.julianschmidt.urlshortify.url.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.validator.routines.UrlValidator;

public class UrlConstraintValidator implements ConstraintValidator<ValidUrl, String> {

    private static final String[] SCHEMES = {"http", "https"};
    private final UrlValidator validator = new UrlValidator(SCHEMES);

    @Override
    public void initialize(ValidUrl constraint) {
        // nothing to do
    }

    @Override
    public boolean isValid(String url, ConstraintValidatorContext context) {
        return validator.isValid(url);
    }
}
