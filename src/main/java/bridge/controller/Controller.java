package bridge.controller;

import bridge.BridgeMaker;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.Player;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;
    private Player player;
    private Result result;

    public Controller(BridgeMaker bridgeMaker) {
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
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputDirection();
        }
    }

    public void setUpBridge(int size) {
        result = new Result();
        bridgeGame = new BridgeGame(new Bridge(bridgeMaker.makeBridge(size)), result);
    }
}
