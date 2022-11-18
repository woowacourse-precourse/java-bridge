package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeMaker bridgeMaker;

    private BridgeGame bridgeGame;

    public Controller(InputView inputView, OutputView outputView, BridgeMaker bridgeMaker) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bridgeMaker = bridgeMaker;
        outputView.printStartMessage();
        outputView.printInputLengthMessage();
    }

    public int inputBridgeLength() {
        try {
            String length = inputView.input();
            return inputView.readBridgeSize(length);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBridgeLength();
        }
    }

    public String inputDirection() {
        try {
            String direction = inputView.input();
            return inputView.readMoving(direction);
        } catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputDirection();
        }
    }

    public void setUpBridge(int size) {
        bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(size)));
    }

    public void initialize() {
        setUpBridge(inputBridgeLength());
    }
}
