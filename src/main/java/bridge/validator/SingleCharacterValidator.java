package bridge.validator;

public class SingleCharacterValidator implements Validator<String> {

    @Override
    public boolean test(String target) {
        return target.length() == 1;
    }

    @Override
    public String getMessage() {
        return InputException.SINGLE_CHARACTER.getMessage();
    }
}
