package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.Constants.CommandMark.*;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    private boolean gaming = true;
    private int bridgeNum = 0;
    private int tryCount = 1;

    public void start() {
        outputView.printStart();
        int bridgeSize = inputBridgeSize();
        List<String> correctBridge = prepareBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(correctBridge);
        boolean isSuccess = play(bridgeSize, bridgeGame);
        outputView.printResult(bridgeGame.getBridgeMap(), isSuccess, this.tryCount);
    }

    private List<String> prepareBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private boolean play(int bridgeSize, BridgeGame bridgeGame) {
        boolean isCorrect = false;
        while (bridgeNum < bridgeSize && gaming) {
            String moving = inputMoving();
            isCorrect = bridgeGame.move(bridgeNum, moving);
            outputView.printMap(bridgeGame.getBridgeMap());

            if (!isCorrect) failed(bridgeGame);
            if (isCorrect) bridgeNum++;
        }
        return isCorrect;
    }

    private void failed(BridgeGame bridgeGame) {
        String command = inputCommand();
        if (command.equals(RETRY.mark())) {
            bridgeGame.retry();
            tryCount += 1;
            bridgeNum = 0;
        }
        if (command.equals(QUIT.mark())) {
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
