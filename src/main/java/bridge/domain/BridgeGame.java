package bridge.domain;

import static bridge.Constants.COMPLETE;
import static bridge.Constants.FAIL;

import bridge.domain.bridgemessageadd.BridgeMessageAdder;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final List<String> upBridge = new ArrayList<>();
    private final List<String> downBridge = new ArrayList<>();
    private final BridgeMessageAdder bridgeMessageAdder = new BridgeMessageAdder(upBridge, downBridge);
    private int index = 0;
    private int retryNumber = 1;

    public BridgeGame(final List<String> bridge) {
        this.bridge = bridge;
    }

    //사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move(final String inputPosition) {
        boolean moveResult = inputPosition.equals(bridge.get(index));
        if (moveResult) {
            bridgeMessageAdder.addPassBridgeMessage(inputPosition);
            index++;
            return true;
        }
        bridgeMessageAdder.addFailBridgeMessage(inputPosition);
        return false;
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    public void retry() {
        index = 0;
        upBridge.clear();
        downBridge.clear();
        retryNumber++;
    }

    public boolean checkComplete() {
        return index == bridge.size();
    }

    public String makeResultOfCompletionMessage() {
        if (checkComplete()) {
            return COMPLETE;
        }
        return FAIL;
    }

    public List<String> makeBridgeMessage() {
        List<String> bridgeMessage = new ArrayList<>();
        bridgeMessage.add("[" + String.join("|", upBridge) + "]");
        bridgeMessage.add("[" + String.join("|", downBridge) + "]");
        return bridgeMessage;
    }

    public int getRetryNumber() {
        return retryNumber;
    }
}
