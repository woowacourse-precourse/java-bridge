package bridge;

import java.util.List;

import static bridge.ui.InputView.*;
import static bridge.ui.OutputView.*;
import static bridge.util.PrintMessage.FAIL;
import static bridge.util.PrintMessage.QUIT;

public class BridgeGamePlay {
    public Boolean retryGame(int bridgeSize, List<String> randomBridge, BridgeGame bridgeGame) {
        printChooseRetryGameMessage();
        String retryGameInput = readGameCommand();
        if (retryGameInput.equals(QUIT)) {
            printResult(bridgeGame.getBridges(), false, false);
            printTotalTryCountMessage(bridgeGame.getCount());
            return true;
        }
        return initGame(bridgeSize, new BridgeGame(), randomBridge);
    }

    public Boolean initGame(int bridgeSize, BridgeGame bridgeGame, List<String> randomBridge) {
        List<String> bridges = bridgeGame.getBridges();
        for (int i = 0; i < bridgeSize; i++) {
            printChooseSpaceToMoveMessage();
            bridges = bridgeGame.move(readMoving(), i, randomBridge.get(i));
            printMap(bridges);
            if (bridges.get(2).equals(FAIL)) return false;
        }
        printResult(bridges, true, true);
        printTotalTryCountMessage(bridgeGame.getCount());
        return true;
    }

    public void playGame(BridgeGame bridgeGame) {
        int count = bridgeGame.getCount();
        int bridgeSize = readBridgeSize();
        List<String> randomBridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
        if (!initGame(bridgeSize, bridgeGame, randomBridge)) {
            while (!bridgeGame.retry(bridgeSize, randomBridge)) {
                count += 1;
            }
        }
        bridgeGame.setCount(count);
    }
}
