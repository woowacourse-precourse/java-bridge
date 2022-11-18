package bridge;

public class Validator {
    public void validateNumber(String bridgeNumber) {
        for (int index = 0; index < bridgeNumber.length(); index++) {
            if (!Character.isDigit(bridgeNumber.charAt(index))) {
                System.out.println(ErrorMessage.NUMBER_ERROR.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateRange(int bridgeNumber) {

    }

    public void validateLength(String userInput) {

    }

    public void validateMoving(String moving) {

    }

    public void validateGameCommand(String gameCommand) {

    }
}
