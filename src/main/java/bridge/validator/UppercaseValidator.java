package bridge.validator;

public class UppercaseValidator implements Validator<String> {

    @Override
    public boolean test(String target) {
        return target.chars()
                .map(i -> (char) i)
                .allMatch(Character::isUpperCase);
    }

    @Override
    public String getMessage() {
        return InputException.UPPERCASE.getMessage();
    }
}
