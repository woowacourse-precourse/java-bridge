package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.input.InputString;
import bridge.input.InputView;
import bridge.output.OutputView;

import java.util.List;

public class BridgeController {
    private final BridgeGame bridgeGame = new BridgeGame();

    public void start() {
        OutputView.printStartGame();
        List<String> bridge = createBridge();
        boolean isSuccess = play(bridge);
        OutputView.printResult(isSuccess, bridgeGame.getFirstRoad(), bridgeGame.getSecondRoad(), bridgeGame.getRoundCount());
    }

    private boolean play(List<String> bridge) {
        while (true) {
            boolean isCorrect = false;
            for (int count = 0; count < bridge.size(); count++) {
                isCorrect = moveAndPrint(bridge, count);
                if (isCorrect) continue;
                if (isQuit(InputView.readGameCommand())) return false;
                bridgeGame.retry();
                break;
            }
            if (!isCorrect) continue;
            return true;
        }
    }

    private boolean moveAndPrint(List<String> bridge, int count) {
        boolean isCorrect;
        String moveCommand = InputView.readMoving();
        isCorrect = moveCommand.equals(bridge.get(count));
        bridgeGame.move(moveCommand, isCorrect);
        OutputView.printMap(bridgeGame.getFirstRoad(), bridgeGame.getSecondRoad());
        return isCorrect;
    }

    private static boolean isQuit(String retryCommand) {
        return retryCommand.equals(InputString.QUIT);
    }

    private List<String> createBridge() {
        int bridgeSize = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(bridgeSize);
    }
}
