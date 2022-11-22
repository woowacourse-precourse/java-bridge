package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.Model.BridgeMap;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    private static final int ZERO = 0;
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private BridgeMap bridgeMap;
    private boolean isStart = true;

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
        while (isStart) {
            isStart = crossBridge();
            if (isStart) { // 다리를 다 건넜을 때
                break;
            }
            isStart = isStartOrEnd(); //다리를 다 건너지 못했다면
        }
        endGame();
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

    private boolean isStartOrEnd() {
        OutputView.printStartOrEnd();
        return bridgeGame.retry(InputView.readGameCommand());
    }

    private void endGame() {
        OutputView.printEndGame();
        OutputView.printMap(bridgeMap);
        OutputView.printResult(BridgeGame.getPlayCount(), isStart);
    }
}
