package bridge.domain.validator;

public interface Validator {
    void validate(String inputValue) ;

    void validateIsBlank(String inputValue);

    void validateIsInvalid(String inputValue);
}
