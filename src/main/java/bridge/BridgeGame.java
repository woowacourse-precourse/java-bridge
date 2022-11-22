package bridge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private Bridge bridge;
    private BridgeGameResult bridgeGameResult;
    private List<String> userInput;
    private int tryCount;

    public BridgeGame(int size, BridgeMaker bridgeMaker) {
        userInput = new ArrayList<>();
        tryCount = 1;
        bridge = new Bridge(bridgeMaker.makeBridge(size));
        bridgeGameResult = new BridgeGameResult();
    }

    public int getTryCount() {
        return tryCount;
    }

    public List<String> getUserInput() {
        return Collections.unmodifiableList(userInput);
    }

    public Bridge getBridge() {
        return bridge;
    }

    public BridgeGameResult getBridgeGameResult() {
        return bridgeGameResult;
    }

    public List<String> move(String movingCommand) {
        userInput.add(movingCommand);
        return Collections.unmodifiableList(userInput);
    }

    public void retry() {
        userInput.clear();
        tryCount++;
        bridgeGameResult.clear();
    }
}
