package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.Bridge;
import bridge.model.SuccessOrFail;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static Bridge bridge;
    private BridgeGame bridgeGame = new BridgeGame();

    public void createBridge() {
        int bridgeSize = validateBridgeSize();
        bridge = new Bridge(bridgeMaker.makeBridge(bridgeSize));
    }

    private int validateBridgeSize() {
        int bridgeSize = 0;
        try {
            bridgeSize = inputView.readBridgeSize();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return validateBridgeSize();
        }
        return bridgeSize;
    }

    public boolean moveControl(int position) {
        String moving = validateMoving();
        boolean success = canCross(moving, position);
        bridgeGame.move(moving, success, bridge);
        outputView.printMap(bridge);
        return success;
    }

    public boolean canCross(String moving, int position) {
        if (moving.equals(bridge.getShape(position))) {
            return true;
        }
        return false;
    }

    private String validateMoving() {
        String moving = "";
        try {
            moving = inputView.readMoving();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return validateMoving();
        }
        return moving;
    }

    public boolean retryControl() {
        String gameCommand = validateGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry(bridge);
            return true;
        }
        return false;
    }

    private String validateGameCommand() {
        String gameCommand = "";
        try {
            gameCommand = inputView.readGameCommand();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
            return validateGameCommand();
        }
        return gameCommand;
    }

    public boolean complete(int position) {
        if (position >= bridge.length()) {
            return true;
        }
        return false;
    }

    public void playGame(int count, int position) {
        do {
            position = 0;
            count++;
            while (!complete(position) && moveControl(position)) {
                position++;
            }
        } while (!complete(position) && retryControl());
        outputView.printResult(bridge, SuccessOrFail.getSuccessOrFailMessage(complete(position)), count);
    }
}
