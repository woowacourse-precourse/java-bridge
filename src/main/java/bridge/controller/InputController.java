package bridge.controller;

import bridge.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.Validation;

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

    public int getBridgeSize(String inputSize) throws IllegalArgumentException {
        Validation.checkOnlyNumber(inputSize);
        Validation.isValidBridgeSize(inputSize);
        return Integer.parseInt(inputSize);
    }

    public String getBridgeSizeInput() {
        outputView.printGameStart();
        outputView.printEnterSize();
        return inputView.readBridgeSize();
    }

    public String getMovingDirection(String moving) throws IllegalArgumentException {
        Validation.isValidDirection(moving);
        return moving;
    }

    public String getMovingDirectionInput() {
        return inputView.readMoving();
    }

    public String getGameCommand(String command) throws IllegalArgumentException {
        Validation.isValidGameCommand(command);
        return command;
    }

    public String getGameCommandInput() {
        return inputView.readGameCommand();
    }
}
