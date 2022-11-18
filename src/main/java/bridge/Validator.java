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
        if (bridgeNumber < 3 || bridgeNumber > 20) {
            System.out.println(ErrorMessage.RANGE_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void validateLength(String userInput) {
        if (userInput.length() != 1) {
            System.out.println(ErrorMessage.LENGTH_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void validateMoving(char moving) {
        if (moving != 'U' && moving != 'D') {
            System.out.println(ErrorMessage.MOVING_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }

    public void validateGameCommand(char gameCommand) {
        if (gameCommand != 'R' && gameCommand != 'Q') {
            System.out.println(ErrorMessage.GAMECOMMAND_ERROR.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
