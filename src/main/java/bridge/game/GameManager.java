package bridge.game;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.user.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 게임을 진행하는 역할 (사용자와 다리 건너기 게임을 연결하는 클래스)
 * 1. 사용자의 상태를 변경하기 위하여 User 메소드 호출
 * 2. 다리 건너기 게임을 위하여 BridgeMaker 메소드 호출
 * 3. 사용자에게서 입력을 받기 위하여 InputViewer 메소드 호출
 * 4. 사용자의 콘솔 화면에 내용을 출력하기 위하여 OutputViewer 메소드 호출
 */
public class GameManager {

    private static User player;
    private static BridgeGame bridgeGame;

    /**
     * 다리 생성 게임, 사용자 생성
     */
    public GameManager() {
        bridgeGame = new BridgeGame();
        player = new User(true, false, 1);
    }

    /**
     * 게임 초기화
     */
    public void startBridgeGame() {
        OutputView.printGameStartMessage();
        int bridgeSize = askBridgeSize();
        generateBridge(bridgeSize);
    }

    private int askBridgeSize() {
        OutputView.askBridgeSize();
        return InputView.readBridgeSize();
    }

    private void generateBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridgeAnswer = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridgeAnswer(bridgeAnswer);
    }

    /**
     * 게임 진행
     */
    public void playBridgeGame() {
        while (player.isPlayingGame()) {
            moveUser();
            printBridge_userPredict();
            if (isGameSucceed()) break;
            askRestartGame();
        }
        printGameResult();
    }

    // 칸 이동
    private void moveUser() {
        String userMoveDirection = askUserMoveDirection();
        bridgeGame.move(userMoveDirection);
    }

    private String askUserMoveDirection() {
        OutputView.askUserMoveDirection();
        return InputView.readMoving();
    }

    private void printBridge_userPredict() {
    }

    private boolean isGameSucceed() {
        return true;
    }

    private void askRestartGame() {
    }

    private void printGameResult() {
    }

}
