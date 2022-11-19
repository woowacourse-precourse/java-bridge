package bridge.service;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private boolean isCorrect;

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

    // 다리 이동
    public void moveBridge() {
        do {
            try {
                String moving = inputView.readMoving();
                this.isCorrect = bridgeGame.move(moving);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }


    // 재시작 입력받기
    public String isRestartString() {
        String isRestart;
        do {
            try {
                isRestart = inputView.readGameCommand();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return isRestart;
    }

}
