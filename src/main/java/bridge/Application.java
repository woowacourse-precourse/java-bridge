package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));

        while (!bridgeGame.isSuccess()) {
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame);
            if (bridgeGame.isCorrectChoice()) {
                continue;
            }
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
            }
            if (gameCommand.equals("Q")) {
                break;
            }
        }
    }
}
