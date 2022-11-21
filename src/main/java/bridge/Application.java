package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(InputView.readBridgeSize()));

        while (!bridgeGame.isSuccess()) {
            bridgeGame.move(InputView.readMoving());
            OutputView.printMap(bridgeGame);
            if (bridgeGame.isCorrectChoice()) {
                continue;
            }
            String gameCommand = InputView.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
            }
            if (gameCommand.equals("Q")) {
                break;
            }
        }
        OutputView.printResult(bridgeGame);
    }
}
