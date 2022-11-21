package bridge.model;

import bridge.constant.RetryCode;
import bridge.combinator.BridgeCase;

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
                .filter(bridgePrinter -> isAnswer(bridgeToMove, index) == bridgePrinter.isAnswer())
                .filter(bridgePrinter -> isFirst(index) == bridgePrinter.isFirst())
                .filter(bridgePrinter -> bridgeToMove.equals(bridgePrinter.getMark()))
                .findFirst()
                .orElse(BridgeCase.DEFAULT);
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
