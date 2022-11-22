package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Application {
    private static BridgeGame bridgeGame = new BridgeGame();

    private static BridgeAnswer bridgeAnswer = new BridgeAnswer();
    private static OutputView outputView = new OutputView();
    private static boolean retry = true;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
        while (retry) {
            Bridge player = new Bridge(new ArrayList<>());
            if (ongoingGame(player, bridgeAnswer.getBridgeAnswer())) { break; }
            retry = retryGame();
        }
        outputView.printResult(bridgeGame.getBridgeGameResult());
    }

    private static void startGame() {
        System.out.println(PrintWord.START);
        int size = InputView.readBridgeSize();

        bridgeAnswer = bridgeAnswer.makeBridgeAnswer(size);
    }

    private static boolean ongoingGame(Bridge player, Bridge answer) {
        bridgeGame.setBridgeGameResult();
        for (int i = 0; i < answer.getBridge().size(); i++) {
            player.getBridge().add(InputView.readMoving());
            boolean isOver = bridgeGame.move(player, answer, i);
            outputView.printMap(bridgeGame.getBridgeGameResult());
            if (isOver) { return false; }
        }
        return true;
    }

    private static boolean retryGame() {
        return bridgeGame.retry(InputView.readGameCommand());
    }

}
