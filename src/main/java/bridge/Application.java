package bridge;

import ui.InputView;
import ui.OutputView;

import java.util.List;

public class Application {
    static final String PASS = "O";
    static final String FAIL = "X";
    static final String STOP_GAME = "Q";
    static InputView input = new InputView();
    static boolean gamePlayFlag = true;

    public static void main(String[] args) {
        BridgeGame currentBridgeGame = makeBridgeGame();

        OutputView outputView = new OutputView(currentBridgeGame);
        startBridgeGame(currentBridgeGame, outputView);

        outputView.printResult();
    }

    private static BridgeGame makeBridgeGame() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = input.readBridgeSize();

        BridgeRandomNumberGenerator bridgeRanNumGen = new BridgeRandomNumberGenerator();

        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRanNumGen);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return new BridgeGame(bridge);
    }

    private static void startBridgeGame(BridgeGame currentBridgeGame, OutputView outputView) {
        while (gamePlayFlag) {
            String userMoving = input.readMoving();
            String moveResult = currentBridgeGame.move(userMoving);
            outputView.printCurrentGameResult(userMoving, moveResult);

            checkUserWantToRetryIfMovingIsFail(currentBridgeGame, moveResult);

            checkGameIsSuccess(currentBridgeGame, moveResult);
        }
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

    private static void checkGameIsSuccess(BridgeGame currentBridgeGame, String moveResult) {
        if (moveResult.equals(FAIL)) {
            return;
        }

        if (currentBridgeGame.isSuccessGame()) {
            currentBridgeGame.setGamePassFlag(true);
            stopBridgeGame();
        }
    }

    private static void stopBridgeGame() {
        gamePlayFlag = false;
    }
}
