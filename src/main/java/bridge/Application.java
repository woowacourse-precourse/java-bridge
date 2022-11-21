package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static InputView inputView = new InputView();
    
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView outputView = new OutputView();

    public static void main(String[] args) {

        BridgeFactory bridgeFactory = new BridgeFactory();
        BridgeGameEngine bridgeGameEngine = new BridgeGameEngine(bridgeGame);

        System.out.println("다리 건너기 게임을 시작합니다");

        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeFactory.makeBridgeByBridgeMaker(bridgeSize);

        int gameCount = 0;

        while (true) {
            gameCount++;
            Bridge userBridge = bridgeFactory.makeUserBridge();

            PlayerStatus playerStatus = bridgeGameEngine.playerMoveBridge(bridge, userBridge);

            if (finishGamePlayerWin(gameCount, userBridge, playerStatus)) {
                break;
            }

            if (finishGamePlayerLose(gameCount, userBridge, playerStatus)) {
                break;
            }
        }
    }

    private static boolean finishGamePlayerWin(int gameCount, Bridge userBridge, PlayerStatus playerStatus) {
        if (playerStatus.isMatchingFlag()) {
            outputView.printResult(userBridge, gameCount, playerStatus);
            return true;
        }
        return false;
    }

    private static boolean finishGamePlayerLose(int gameCount, Bridge userBridge, PlayerStatus playerStatus) {
        String retryCommand = inputView.readGameCommand();

        if (bridgeGame.retry(retryCommand)) {
            outputView.printResult(userBridge, gameCount, playerStatus);
            return true;
        }
        return false;
    }


}
