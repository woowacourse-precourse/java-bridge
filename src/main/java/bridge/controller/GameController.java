package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeGame;
import bridge.model.Moved;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    InputView inputView = new InputView();
    OutputView  outputView = new OutputView();
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;
    Bridge bridge;

    public GameController(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridgeGame = new BridgeGame();
    }

    public void playGame() {
        int tryCount = 0;
        informStart();
        buildBridge();
        tryCount = doRepeatBridgeGame();
        printResult(tryCount,bridge);
    }

    private void informStart() {
        outputView.printStartGame();
    }

    private void printNowBridge() {
        outputView.printMap(this.bridge);
    }

    private void printResult(int tryCount, Bridge bridge) {
        outputView.printResult(tryCount,bridge);
    }

    private Integer inputBridgeSize() {
        return inputView.readBridgeSize();
    }

    private String inputUserMove() {
        return inputView.readMoving();
    }

    private boolean askRetry() {
        String retryFlag = inputView.readGameCommand();
        return retryFlag.equals("R");
    }

    private void buildBridge() {
        Integer bridgeSize = inputBridgeSize();
        List<String> bridgeStrs =  bridgeMaker.makeBridge(bridgeSize);
        bridge = new Bridge(bridgeStrs);
    }

    private int doRepeatBridgeGame() {
        int tryCount = 0;
        do {
            tryCount += 1;
            bridge = bridgeGame.retry(bridge); // (재시도)초기화 처리
            if (doRepeatBridgeMove()) {
                break;
            }
        }while(askRetry());
        return tryCount;
    }

    private boolean doRepeatBridgeMove() {
        for (int idx = 0; idx < bridge.getBridgeSpaces().size(); idx++) {
            String userDirection = inputUserMove();
            Moved userMoved = bridgeGame.move(userDirection,bridge.getBridgeSpaces().get(idx));
            bridge.getBridgeSpaces().get(idx).setMyMoved(userMoved);
            printNowBridge();
            if(userMoved == Moved.CANT) break;
        }
        return bridgeGame.checkAllDone(bridge);
    }

}
