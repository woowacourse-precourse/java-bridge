package bridge.Controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.Domain.BridgeGame;
import bridge.Domain.BridgeMaker;
import bridge.View.InputView;

public class GameController {
    InputView inputView = new InputView();
    BridgeGame bridgeGame = new BridgeGame();
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void GAMESTART() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeGame.setBridgeSize(inputView.readBridgeSize());
        bridgeMaker.makeBridge(bridgeGame.getBridgeSize());
    }

    public void RUNPROCESS() {

    }
}
