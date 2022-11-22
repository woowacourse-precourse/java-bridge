package bridge;

import java.util.List;

public class GamePlay {

    private final InputView inputView = new InputView();
    private final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private final BridgeGame bridgeGame = new BridgeGame();
    private final OutputView outputView = new OutputView();

    private static int gameCount = 0;

    public void run() {
        List<String> correctBridge = setBridgeGame();
        String gameCommand = "R";
        String result = null;
        while (gameCommand.equals("R")) {
            gameCount++;
            result = playBridgeGame(correctBridge);
            gameCommand = setRestartGame(result);
        }
        outputView.printResult(result, gameCount, bridgeGame);
    }

    private List<String> setBridgeGame() {
        outputView.printStart();
        int bridgeSize = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private String playBridgeGame(List<String> correctBridge) {
        for (int i = 0; i < correctBridge.size(); i++) {
            String moving = inputView.readMoving();
            String result = bridgeGame.move(moving, correctBridge, i);
            outputView.printMap(bridgeGame.getUpBridge(), bridgeGame.getDownBridge(), i);
            if (result.equals("X")) {
                return "X";
            }
        }
        return "O";
    }

    private String setRestartGame(String result) {
        if (result.equals("X")) {
            String gameCommand = inputView.readGameCommand();
            if (gameCommand.equals("R")) {
                bridgeGame.retry();
                return "R";
            }
        }
        return "Q";
    }
}
