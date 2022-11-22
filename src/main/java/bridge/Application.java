package bridge;

import java.util.List;

import static bridge.PrintMessage.FAIL;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printGameStartMessage();
        outputView.printInputBridgeSizeMessage();

        try {
            int bridgeSize = inputView.readBridgeSize();

            List<String> randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
            System.out.println(randomBridge);

            BridgeGame bridgeGame = new BridgeGame();
            for (int i = 0; i < bridgeSize; i++) {
                outputView.printChooseSpaceToMoveMessage();
                String space = inputView.readMoving();

                List<String> bridges = bridgeGame.move(space, i, randomBridge.get(i));
                outputView.printMap(bridges);

                if (bridges.get(2).equals(FAIL)) {
                    break;
                }
            }

            outputView.printChooseRetryGameMessage();
            inputView.readGameCommand();

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
