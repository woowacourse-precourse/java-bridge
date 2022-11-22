package bridge;

import bridge.enums.BridgeLine;
import bridge.enums.EndCommand;
import java.util.EnumMap;
import java.util.List;

public class Application {
    private static final InputView inputView = InputView.getInstance();
    private static final OutputView outputView = OutputView.getInstance();

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = constructBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        int tryCnt = play(bridgeGame);
        calResult(bridgeGame, tryCnt);
    }

    private static List<String> constructBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static int play(BridgeGame bridgeGame) {
        int tryCnt = 1;
        while (!bridgeGame.isCompleted()) {
            EnumMap<BridgeLine, List<String>> curState = bridgeGame.move(inputView.readMoving());
            outputView.printMap(curState);
            if (bridgeGame.wasFailedToMove()) {
                tryCnt = restartOrEndGame(bridgeGame, tryCnt);
            }
        }
        return tryCnt;
    }

    private static void calResult(BridgeGame bridgeGame, int tryCnt) {
        outputView.printResult(bridgeGame.getCurrentBridgeState(), bridgeGame.getGameState(), tryCnt);
    }

    private static int restartOrEndGame(BridgeGame bridgeGame, int tryCnt) {
        String command = inputView.readGameCommand();

        if (command.equals(EndCommand.QUIT.getCommandStr())) {
            return tryCnt;
        }

        bridgeGame.retry();
        return tryCnt + 1;
    }

}
