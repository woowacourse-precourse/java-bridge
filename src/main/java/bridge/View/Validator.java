package bridge.View;

public class Validator {
    public Validator() {
    }

    boolean validateGameCommand(String command) {
        try {
            validateIsRightCommand(command);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    void validateIsRightCommand(String command) throws IllegalArgumentException {
        if (!command.equals("R") && !command.equals("Q")) {
            throw new IllegalArgumentException(ExceptionMessage.GAME_COMMAND_EXCEPTION_MESSAGE.getExceptionMessage());
        }
    }
}
