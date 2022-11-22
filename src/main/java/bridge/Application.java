package bridge;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    private static Bridge bridge;
    private static Player player;
    private static BridgeGame bridgeGame;

    public static void main(String[] args) {
        setGame();
        while (true) {
            String inputStep = move();
            if (bridgeGame.isSuccess(inputStep)) {
                if (bridgeGame.isFinish()) {
                    win(inputStep);
                    break;
                }
                continue;
            }
            String retry = loseAndRetryCheck();
            if (retry.equals("Q")) {
                outputView.printResult(bridge, player, inputStep);
                break;
            }
            bridgeGame.retry();
        }
    }

    private static void win(String lastStep) {
        bridgeGame.win();
        outputView.printResult(bridge, player, lastStep);
    }

    private static String loseAndRetryCheck() {
        bridgeGame.lose();
        String retry = inputView.readGameCommand();
        return retry;
    }

    private static String move() {
        String inputStep = inputView.readMoving();
        bridgeGame.move();
        outputView.printMap(bridge, player, inputStep);
        return inputStep;
    }

    private static void setGame() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = inputView.readBridgeSize();
        bridge = new Bridge(bridgeSize, bridgeRandomNumberGenerator);
        player = new Player();
        bridgeGame = new BridgeGame(player, bridge);
    }
}
