package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {

    private BridgeGame bridgeGame = new BridgeGame();

    private void createBridge(int bridgeSize) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.createBridge(randomBridge);
    }

    private String loadMoveDirection() {
        return InputView.readMoving();
    }

    private void playRound() {
        String moveDirection = loadMoveDirection();
        List<List<String>> bridgeRecord = bridgeGame.getRecordByMove(moveDirection);
        OutputView.printMap(bridgeRecord);
    }
}