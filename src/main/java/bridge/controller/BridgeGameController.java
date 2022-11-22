package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {
    private final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private final List<String> bridge = bridgeMaker.transmitBridge();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();
    private List<List<String>> resultMap;

    private int attempts = 1;

    public void run() {
        outputView.requestStartMessage();
        while (true) {
            resultMap = new ArrayList<>();
            if (isEnd()){
                return;
            }
            attempts++;
        }
    }

    public boolean isEnd() {
        if (isSuccessfulCrossing()) {
            outputView.printResult(resultMap, true, attempts);
            return true;
        }
        if (!isRetry()) {
            outputView.printResult(resultMap, false, attempts);
            return true;
        }
        return false;
    }

    private boolean isSuccessfulCrossing() {
        for (String block : bridge) {
            String currentMoving = inputView.readMoving();
            boolean isSuccess = bridgeGame.move(block, currentMoving);
            addNewMap(currentMoving, isSuccess);
            if (!isSuccess) {
                return false;
            }
        }
        return true;
    }

    private void addNewMap(String currentMoving, boolean isSuccess){
        List<String> newMap = outputView.printMap(currentMoving, isSuccess, resultMap);
        resultMap.add(newMap);
    }


    private boolean isRetry() {
        String inputForRestart = inputView.readGameCommand();
        return bridgeGame.retry(inputForRestart);
    }

}
