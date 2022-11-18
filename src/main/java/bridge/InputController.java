package bridge;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public int getBridgeSize() throws IllegalArgumentException {
        String inputSize = inputView.readBridgeSize();

        Validation.checkOnlyNumber(inputSize);
        Validation.isValidBridgeSize(inputSize);
        return Integer.parseInt(inputSize);
    }

    public String getMovingDirection() throws IllegalArgumentException {
        String moving = inputView.readMoving();
        Validation.isValidDirection(moving);
        return moving;
    }

    public String getGameCommand() throws IllegalArgumentException {
        String command = inputView.readGameCommand();
        Validation.isValidGameCommand(command);
        return command;
    }
}
