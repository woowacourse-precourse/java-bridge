package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.Model.VO.BridgeSize;
import bridge.View.InputView;
import bridge.View.OutputView;

public class MainController {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void initGame(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        BridgeSize bridgeSize = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(bridgeSize);
    }
}
