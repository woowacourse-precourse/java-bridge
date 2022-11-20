package bridge;

public class BridgePlay {
    public String requestReadMoving() {
        InputView inputView = new InputView();
        String moveCommand = inputView.readMoving();
        try {
            isValidMove(moveCommand);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            moveCommand = inputView.readMoving();
        }
        return moveCommand;
    }
    public boolean isValidMove(String moveCommand) {
        if(!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_COMMAND.toString());
        }
        return true;
    }
    public String requestReadRetry() {
        InputView inputView = new InputView();
        String retryCommand = inputView.readGameCommand();
        try {
            isValidRetry(retryCommand);
        } catch (IllegalArgumentException e) {
            e.getMessage();
            retryCommand = inputView.readGameCommand();
        }
        return retryCommand;
    }
    public boolean isValidRetry(String retryCommand) {
        if(!(retryCommand.equals("Q") || retryCommand.equals("R"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_RETRY_COMMAND.toString());
        }
        return true;
    }
}
