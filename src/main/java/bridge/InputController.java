package bridge;

import java.util.List;

public class InputController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    public InputController(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
    }

    public List<String> getBridge(int size) throws IllegalArgumentException {
        return bridgeMaker.makeBridge(size);
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
