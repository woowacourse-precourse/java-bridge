package bridge.service;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private BridgeGame bridgeGame;
    private InputView inputView;

    public BridgeService() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
    }

    // 게임 시작
    public void initGame() {
        inputView.initBridgeGame();
    }

    // 다리의 길이 생성
    public void bridgeMake() {
       do {
            try {
                int size = inputView.readBridgeSize();
                bridgeGame.setBridgeMake(size);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

}
