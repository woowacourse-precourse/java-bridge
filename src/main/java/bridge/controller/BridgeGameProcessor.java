package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Collections;

public class BridgeGameProcessor {

    private BridgeGame bridgeGame;
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public BridgeGameProcessor(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
    }

    public void crossBridge() {
        while (bridgeGame.isNotOver()) {
            String direction = chooseDirection();
            makeMove(direction);
        }
    }

    public String chooseDirection() {
        outputView.printInputMoveMessage();
        String direction = inputView.readMoving();

        return direction;
    }

    public void makeMove(String direction) {
        boolean moveSuccess = bridgeGame.move(direction);

        outputView.printMap(Collections.unmodifiableList(bridgeGame.getUserBridge()));
        if (moveSuccess == false) {
            moveFail();
        }
    }

    private void moveFail() {
        outputView.printInputRetrialMessage();
        String gameCommand = inputView.readGameCommand();
        if (gameCommand.equals("R")) {
            bridgeGame.retry();
        }
        if (gameCommand.equals("Q")) {
            bridgeGame.giveUp();
        }
    }
}
