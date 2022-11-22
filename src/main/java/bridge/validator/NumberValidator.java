package bridge.validator;

public class NumberValidator implements Validator<String> {

    @Override
    public boolean test(String target) {
        try {
            Integer.parseInt(target);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getMessage() {
        return InputException.NUMBER.getMessage();
    }
}
