package bridge.Controller;

import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

public class GameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    public GameController(BridgeGame bridgeGame, BridgeMaker bridgeMaker) {
        this.bridgeGame = bridgeGame;
        this.bridgeMaker = bridgeMaker;
    }

    public void GAMESTART() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int input = inputView.readBridgeSize();
        bridgeGame.setBridge(bridgeMaker.makeBridge(input));
    }

    public void RUNPROCESS() {
        bridgeGame.increaseGameCount();
        for (int i = 0; i < bridgeGame.getBridgeSize(); i++) {
            boolean match = bridgeGame.move(inputView,outputView,i);
            if (!match) { break; }
        }
    }

    public boolean SELECTRESTART() {
        return bridgeGame.retry(inputView);
    }

    public void STOPGAME() {
        outputView.printResult(bridgeGame);
    }


}
