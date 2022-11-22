package bridge.Controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMap;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;
    private BridgeMap bridgeMap;
    private boolean isStart = true;

    public void run() {
        OutputView.printInit();
        makeBridge();
        while (isStart) {
            crossBridge();
        }
    }

    private void makeBridge() {
        BridgeGame.saveBridgeSize(InputView.readBridgeSize());
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(BridgeGame.getBridgeSize()));
        System.out.println(); // 실행 결과에 맞추어 한줄 엔터 기능
    }

    private boolean crossBridge() {
        boolean gameState;
        bridgeMap = new BridgeMap();

        return true;
    }

}
