package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.Objects;

public class Application {
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static boolean isGameOver = false;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printGameStartMessage();
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(InputView.readBridgeSize()));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        System.out.println("bridge.getBridge() = " + bridge.getBridge());
        doBridgeGame(bridge, bridgeGame, isGameOver);
    }

    private static void doBridgeGame(Bridge bridge, BridgeGame bridgeGame, boolean isGameOver) {
        do {
            boolean isMoveFail = moveForward(bridgeGame);
            if (isMoveFail) {
                isGameOver = handleRestartAndQuit(InputView.readGameCommand(), bridgeGame, bridge);
            }
            isGameOver = isEndOfBridge(bridge, bridgeGame, isGameOver);
        } while (!isGameOver);
    }

    private static boolean isEndOfBridge(Bridge bridge, BridgeGame bridgeGame, boolean isGameOver) {
        if (bridgeGame.getCurrentPosition() == bridge.getSize() - 1) {
            isGameOver = true;
            OutputView.printResult(bridgeGame);
        }
        return isGameOver;
    }

    private static boolean moveForward(BridgeGame bridgeGame) {
        boolean isMoveFail = bridgeGame.move(InputView.readMoving());
        OutputView.printMap(bridgeGame.getBridgeGameResult());
        return isMoveFail;
    }

    private static boolean handleRestartAndQuit(String command, BridgeGame bridgeGame, Bridge bridge) {
        if (Objects.equals(command, "R")) {
            bridgeGame.retry(bridge);
            return false;
        }
        OutputView.printResult(bridgeGame);
        return true;
    }
}