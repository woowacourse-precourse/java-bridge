package bridge;

public class ValidateError {
    public void validIsNumber(String userInput) {
        try {
            Double.parseDouble(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    public void validIsInRange(String userInput) {
        Integer userInputChangeNumber = Integer.parseInt(userInput);
        if (userInputChangeNumber < 3 || 20 < userInputChangeNumber) {
            throw new IllegalArgumentException(ErrorMessage.NOT_IN_RANGE.getMessage());
        }
    }

    public void validIsNotSuitableMovingCommand(String userInput) {
        if (!(userInput.equals("U")||userInput.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUITABLE_MOVING_COMMAND.getMessage());
        }
    }

    public void validIsNotSuitableEndCommand(String userInput) {
        if (!(userInput.equals("R")||userInput.equals("Q"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_SUITABLE_END_COMMAND.getMessage());
        }
    }
}
