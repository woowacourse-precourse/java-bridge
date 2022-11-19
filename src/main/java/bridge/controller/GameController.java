package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private boolean gaming = true;
    private int bridgeNum = 0;

    private List<String> prepareBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private boolean play(int bridgeSize, BridgeGame bridgeGame) {
        boolean isCorrect = false;
        while (bridgeNum < bridgeSize && gaming) {
            String moving = inputMoving();
            isCorrect = bridgeGame.checkMove(bridgeNum, moving);
            outputView.printMap(bridgeGame.getBridgeMap());

            if (!isCorrect) failed(bridgeGame);
            if (isCorrect) bridgeNum++;
        }
        return isCorrect;
    }

    private void failed(BridgeGame bridgeGame) {
        String command = inputCommand();
        if (command.equals("R")) {
            bridgeGame.retry();
            bridgeNum = 0;
        }
        if (command.equals("Q")) {
            gaming = false;
        }
    }

    private int inputBridgeSize() {
        outputView.printInputBridgeSize();
        return inputView.readBridgeSize();
    }

    private String inputMoving() {
        outputView.printInputMoving();
        return inputView.readMoving();
    }

    private String inputCommand() {
        outputView.printInputCommand();
        return inputView.readGameCommand();
    }
}
