package bridge;

public class InputController {
    private final InputView inputView = new InputView();
    private final Validation validation = new Validation();

    public int getBridgeSize() throws IllegalArgumentException {
        String inputSize = inputView.readBridgeSize();

        validation.isValidBridgeSize(inputSize);
        validation.checkOnlyNumber(inputSize);
        return Integer.parseInt(inputSize);
    }

    public String getMovingDirection() throws IllegalArgumentException {
        String moving = inputView.readMoving();

        validation.isValidDirection(moving);
        return moving;
    }

    public String getGameCommand() throws IllegalArgumentException {
        String command = inputView.readGameCommand();

        validation.isValidGameCommand(command);
        return command;
    }
}
