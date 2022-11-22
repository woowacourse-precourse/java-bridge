package bridge.view.validation;


public class InputValidation {

    public boolean test(String readLine, boolean isDigit) {
        try {
            isDigit = isDigits(readLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return isDigit;
    }

    public boolean isDigits(String readLine) {
        if (!readLine.chars().allMatch(Character::isDigit) || readLine.chars().anyMatch(value -> value == ' ')) {
            throw new IllegalArgumentException("[ERROR] Bridge size is Exception !!");
        }
        return true;
    }
}
