package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        outputView.printOf(OutputView.MESSAGE_GAME_START);
        outputView.printOf(OutputView.MESSAGE_INPUT_BRIDGE_SIZE);
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        while (true) {
            outputView.printOf(OutputView.MESSAGE_INPUT_BRIDGE_MOVING);
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getResult());
            if (bridgeGame.isFinishBridge()) {
                break;
            }

            if (bridgeGame.isGameEnd()) {
                outputView.printOf(OutputView.MESSAGE_RETRY_OR_EXIT);
                String gameCommand = inputView.readGameCommand();
                if (!bridgeGame.retry(gameCommand)) {
                    break;
                }
            }
        }
        outputView.printResult(bridgeGame.isSuccess(), bridgeGame.getGameCount());
    }
}
