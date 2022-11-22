package bridge;

import java.util.EnumMap;
import java.util.List;

public class Application {
    private static final InputView inputView = InputView.getInstance();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = constructBridge(bridgeSize);

        play(bridge);
    }

    private static List<String> constructBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static void play(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        do {
            String moveChoice = inputView.readMoving();
            List<EnumMap<ChoiceOrResult, String>> curState = bridgeGame.move(moveChoice);
            if (bridgeGame.wasFailedToMove()) {
                restartOrEndGame(bridgeGame);
            }
        } while (!bridgeGame.isCompleted());

    }

    private static void restartOrEndGame(BridgeGame bridgeGame) {
        String command = inputView.readGameCommand();

        if (command.equals(Command.QUIT.getCommandStr())) {
            return;
        }

        bridgeGame.retry();
    }
}
