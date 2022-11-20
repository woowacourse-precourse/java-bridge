package bridge;

import java.util.List;

public class Application {
    private static BridgeGame bridgeGame;
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    public static void main(String[] args) {
        bridgeGame = new BridgeGame(GameSetter());
        while (!bridgeGame.gameFinishedCheck()) {
            Boolean correct = move();
            outputView.printMap(bridgeGame, correct);
            if (!correct) {
                // TODO: 게임 실패, 재시작 여부 물어봄
            }
        }
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
}