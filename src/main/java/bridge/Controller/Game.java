package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.Model.BridgeMap;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    private static final int ZERO = 0;
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private BridgeMap bridgeMap;

    public void run() {
        OutputView.printInit();
        makeBridge();
        startGame();
    }

    private void makeBridge() {
        BridgeGame.saveBridgeSize(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(BridgeGame.getBridgeSize()));
        System.out.println(); // 한줄 엔터
    }

    private void startGame() {
        boolean isStart = true;
        while(isStart) {
            BridgeGame.plusPlayCount();
            isStart = crossBridge();
        }
    }

    private boolean crossBridge() {
        boolean gameState;
        bridgeMap = new BridgeMap();
        for (int position = ZERO; position < BridgeGame.getBridgeSize(); position++) {
            gameState = isCrossed(position);
            if (!gameState) {
                return false;
            }
        }
        return true;
    }

    private boolean isCrossed(int position) {
        boolean gameState;
        OutputView.printMove();
        gameState = bridgeGame.move(InputView.readMoving(), bridgeMap, position);
        OutputView.printMap(bridgeMap);
        return gameState;
    }
}
