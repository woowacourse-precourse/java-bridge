package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class Game {

    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private BridgeGame bridgeGame;

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
        }
    }
}
