package bridge;

import bridge.game.BridgeGame;
import bridge.user.User;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class temp {
}

// TODO: GameManager

package bridge.game;

        import bridge.BridgeMaker;
        import bridge.user.User;
        import bridge.view.InputView;
        import bridge.view.OutputView;

        import java.util.List;

/**
 * 게임을 진행하는 역할
 * 1. 사용자에게서 입력을 받기 위해서 InputViewer 메소드 호출
 * 2. 사용자의 콘솔 화면에 내용을 출력하기 위해 OutputViewer 메소드 호출
 * 3. 다리 건너기 게임을 위하여 BridgeMaker 메소드 호출
 */
public class GameManager {

    private static User player;
    private static BridgeGame bridgeGame;

    public GameManager() {
        bridgeGame = new BridgeGame();
        player = new User(true, false, 1);
        OutputView.printGameStartMessage();
    }

    public static void playBridgeGame() {
        generateBridgeAnswer();
        while (player.isPlayingGame()) {
            moveUser();
            printBridge_userPredict();
            if (isGameSucceed()) break;
            askRestartGame();
        }
        printGameResult();
    }

    private static void generateBridgeAnswer() {
        int bridgeSize = InputView.readBridgeSize();
        List<String> newBridge = BridgeMaker.makeBridge(bridgeSize);
        bridgeGame.setBridgeAnswer(newBridge);
    }

    private static void moveUser() {
        String userMoveDirection = InputView.readMoving();
        bridgeGame.move(userMoveDirection);
    }

    private static void printBridge_userPredict() {
        OutputView.printMap();
    }

    private static boolean isGameSucceed() {
        return true;
    }

    private static void askRestartGame() {
    }

    private static void printGameResult() {
        OutputView.printResult();
    }

}
