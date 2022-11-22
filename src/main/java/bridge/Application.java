package bridge;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        BridgeMaker bridgeMaker =
                new BridgeMaker(new BridgeRandomNumberGenerator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Player player = new Player();
        outputView.printStart();
        outputView.printBridgeSizeInput();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge.size());
        boolean isRun = true;
        while (isRun) {
            outputView.printMoveInput();
            String moving = inputView.readMoving();
            Boolean moveResult = bridgeGame.move(bridge, moving);
            outputView.printMap(bridgeGame.getPlayerPos(), bridge, moveResult);
            if (!moveResult) {
                outputView.printCommandInput();
                String command = inputView.readGameCommand();
                if ("R".equals(command)) {
                    bridgeGame.retry();
                }
                if ("Q".equals(command)) {
                    isRun = false;
                }
            }
            if (bridgeGame.isClear()) {
                isRun = false;
            }
        }
        outputView.printResult(bridgeGame.getPlayerPos(), bridge, bridgeGame.isClear(), bridgeGame.getTotalTry());
    }

    private static void init() {

    }
}
