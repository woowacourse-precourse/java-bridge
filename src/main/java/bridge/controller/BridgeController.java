package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeController {
    private OutputView outputView;
    private InputView inputView;
    private BridgeGame bridgeGame;

    public BridgeController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
    }

    public void startController() {
        outputView.printStart();
    }

    public void setBridgeController() {
        int size = inputView.readBridgeSize();
        bridgeGame.setBridge(size);
    }

    public void moveController() {
        String move = inputView.readMoving();
        List<String> bridge = bridgeGame.move(move);
        outputView.printMap(bridge);
        subMoveController(bridgeGame.getUserState());
    }

    private void subMoveController(String userState) {
        if (userState.equals("Over")) {
            retry();
        } else if (userState.equals("Playing")) {
            moveController();
        } else if (userState.equals("Success")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), userState);
        }
    }

    public void retry() {
        String command = inputView.readGameCommand();
        if (command.equals("R")) {
            bridgeGame.retry();
            moveController();
        } else if (command.equals("Q")) {
            outputView.printResult(bridgeGame.getBridgeState(), bridgeGame.getTryTime(), bridgeGame.getUserState());
        }
    }
}
