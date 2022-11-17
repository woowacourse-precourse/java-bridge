package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        while (true) {
            int positiion = 0;
            while (positiion < bridge.size() - 1 && positiion != -1) {
                positiion = bridgeGame.move(InputView.readMoving());
                OutputView.printMap(bridgeGame);
            }
            if (positiion == -1) {
                String command = InputView.readGameCommand();
                if (command.equals("Q")) {
                    OutputView.printResult(bridgeGame);
                    break;
                }
                bridgeGame.retry();
                continue;
            }
            OutputView.printResult(bridgeGame);
            break;
        }
    }
}
