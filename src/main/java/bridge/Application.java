package bridge;

import bridge.controller.BridgeGame;
import bridge.domain.GameStatus;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = init();
        GameStatus gameStatus = GameStatus.CONTINUE;

        while(gameStatus.equals(GameStatus.CONTINUE)) {
            move(bridgeGame);
            gameStatus = getGameStatus(bridgeGame);
        }
    }

    private static BridgeGame init() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        BridgeGame bridgeGame = new BridgeGame(bridgeMaker, new InputView(), new OutputView());
        createBridge(bridgeGame);

        return bridgeGame;
    }

    private static void createBridge(BridgeGame bridgeGame) {
        while (true){
            try {
                bridgeGame.readBridgeSize();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private static void move(BridgeGame bridgeGame) {
        while (true) {
            try {
                bridgeGame.move();
                break;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }

    private static GameStatus getGameStatus(BridgeGame bridgeGame) {
        GameStatus gameStatus = bridgeGame.currentStatus();

        if(gameStatus.equals(GameStatus.OVER))
            gameStatus=readRestartOption(bridgeGame);

        return gameStatus;
    }

    private static GameStatus readRestartOption(BridgeGame bridgeGame) {
        while (true) {
            try {
                return bridgeGame.retry();
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            }
        }
    }
}
