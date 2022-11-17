package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.enums.InputKey;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);
        playGame(bridgeGame);
    }

    private static void playGame(BridgeGame bridgeGame) {
        while (true) {
            int positiion = 0;
            positiion = move(bridgeGame, positiion);
            if (positiion == -1 && retryOrNot(bridgeGame)) {
                continue;
            }
            OutputView.printResult(bridgeGame);
            break;
        }
    }

    private static boolean retryOrNot(BridgeGame bridgeGame) {
        String command = InputView.readGameCommand();
        if (command.equals(InputKey.Q.getValue())) {
            return false;
        }
        bridgeGame.retry();
        return true;
    }

    private static int move(BridgeGame bridgeGame, int positiion) {
        while (positiion < bridgeGame.getBridgeSize() - 1 && positiion != -1) {
            positiion = bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
        }
        return positiion;
    }
}
