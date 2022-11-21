package bridge;

public class BridgePlay {
    private final InputView inputView;

    public BridgePlay() {
        inputView = new InputView();
    }

    public String requestReadMoving() {
        String moveCommand = inputView.readMoving();
        try {
            isValidMove(moveCommand);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            moveCommand = requestReadMoving();
        }
        return moveCommand;
    }

    public void isValidMove(String moveCommand) {
        if (!(moveCommand.equals("U") || moveCommand.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.NOT_MOVE_COMMAND.toString());
        }
    }

    public String requestReadRetry() {
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
