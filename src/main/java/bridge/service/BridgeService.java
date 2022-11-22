package bridge.service;

import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeService {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private boolean isCorrect;
    private int gameCount = 1;

    public BridgeService() {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
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

    // 다리 출력
    public void presentMap() {
        List<String> makeBridgeList = bridgeGame.getMakeBridgeList();
        List<String> userSelectList = bridgeGame.getUserSelectList();
        outputView.printMap(makeBridgeList,userSelectList);
    }

    // 재시작 여부
    public boolean isRetry() {
        String isRestart = isRestartString();
        if (bridgeGame.retry(isRestart)) {
            gameCount += 1;
            return true;
        }
        return false;
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

    // 정답일치 여부
    public boolean isKeepGoing() {
        return isCorrect;
    }

    // 최종 결과
    public void exitGame() {
        outputView.printResult(isSuccess(),gameCount);
    }

    // 유저 결과와 다리 결과가 같은지 확인
    public boolean isSuccess() {
        return bridgeGame.getMakeBridgeList().equals(bridgeGame.getUserSelectList());
    }

}
