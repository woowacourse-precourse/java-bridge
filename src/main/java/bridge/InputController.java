package bridge;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;

    public InputController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public int getBridgeSize() throws IllegalArgumentException {
        String inputSize;
        outputView.printGameStart();
        outputView.printEnterSize();
        inputSize = inputView.readBridgeSize();

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
