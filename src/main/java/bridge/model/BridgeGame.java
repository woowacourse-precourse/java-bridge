package bridge.model;

import bridge.constant.RetryCode;
import bridge.drawer.BridgeCase;

import java.util.*;

public class BridgeGame {

    private final List<String> bridge;
    private int count;

    public BridgeGame(List<String> bridge, int count) {
        this.bridge = bridge;
        this.count = count;
    }

    public BridgeCase move(String bridgeToMove, int index) {
        if (index == 0) countUp();
        return Arrays.stream(BridgeCase.values())
                .filter(bridgeCase -> isFirst(index) == bridgeCase.isFirst())
                .filter(bridgeCase -> bridgeToMove.equals(bridgeCase.getMark()))
                .findFirst().orElse(BridgeCase.NOTHING);
    }

    public boolean isAnswer(String bridgeToMove, int index) {
        return bridge.get(index).equals(bridgeToMove);
    }

    public boolean retry(String command) {
        return command.equals(RetryCode.RETRY.getRetryCode());
    }

    public boolean isFirst(int index) {
        return index == 0;
    }

    public void countUp() {
        count += 1;
    }

    public int getCount() {   // 수정해보기
        return count;
    }
}
