package bridge;

import java.util.List;

public class Application {
    private static BridgeGame bridgeGame;
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public static void main(String[] args) {
        bridgeGame = new BridgeGame(GameSetter());
        Boolean correct = null;
        while (!bridgeGame.gameFinishedCheck()) {
            correct = move();
            outputView.printMap(bridgeGame, correct);
            if (!gameContinueCheck(correct)) break;
        }
        outputView.printResult(bridgeGame, correct);
    }

    private static List<String> GameSetter() {
        outputView.startGame();
        int size = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private static Boolean move() {
        String direction = inputView.readMoving();
        return bridgeGame.move(direction);
    }

    private static boolean gameContinueCheck(boolean correct) { // 틀렸을 경우 게임 재시작 여부 확인
        if (correct) return true;
        String retry = inputView.readGameCommand();
        if (retry.equals(InputView.RETRY)) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}