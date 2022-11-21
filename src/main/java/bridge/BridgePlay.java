package bridge;

public class BridgePlay {
    public String requestReadMoving() {
        InputView inputView = new InputView();
        String moveCommand = inputView.readMoving();
        try {
            isValidMove(moveCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveCommand = inputView.readMoving();
        }
        return moveCommand;
    }

    public void isValidMove(String moveCommand) {
        if (!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_COMMAND.toString());
        }
    }

    public String requestReadRetry() {
        InputView inputView = new InputView();
        String retryCommand = inputView.readGameCommand();
        try {
            isValidRetry(retryCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            retryCommand = requestReadRetry();
        }
        return retryCommand;
    }

    public void isValidRetry(String retryCommand) {
        if (!(retryCommand.equals("Q") || retryCommand.equals("R"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RETRY_COMMAND.toString());
        }
    }
}
