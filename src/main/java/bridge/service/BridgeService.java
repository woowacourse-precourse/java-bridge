package bridge.service;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private InputView inputView;

    public BridgeService() {
        this.inputView = new InputView();
    }

    // 게임 시작
    public void initGame() {
        inputView.initBridgeGame();
    }


}
