package bridge;

import ui.InputView;

import java.util.List;

public class Application {
    static final String PASS = "O";
    static final String STOP_GAME = "Q";
    static InputView input = new InputView();
    static boolean gamePlayFlag = true;

    public static void main(String[] args) {
        makeBridgeGame();
    private static BridgeGame makeBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = input.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRanNumGen = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRanNumGen);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }
    private static void checkUserWantToRetryIfMovingIsFail(BridgeGame currentBridgeGame, String moveResult) {
        if (moveResult.equals(PASS)) {
            return;
        }

        if (input.readGameCommand().equals(STOP_GAME)) {
            stopBridgeGame();
            return;
        }

        currentBridgeGame.retry();
    }
    private static void stopBridgeGame() {
        gamePlayFlag = false;
    }
}
