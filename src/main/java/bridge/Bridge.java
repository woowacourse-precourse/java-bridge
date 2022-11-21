package bridge;

import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final BridgeShape bridgeShape = new BridgeShape();

    private final int bridgeSize;

    public Bridge(List<String> bridge) {
        this.bridgeSize = bridge.size();
        this.bridge = new ArrayList<>(bridge);
    }

    public boolean judgeAnswer(String userInput, int idx) {
        validateInputIsUOrD(userInput);
        boolean isUserGetTheRightAnswer = true;
        if (userInput.equals(InputMatcher.UPSIDE_OF_BRIDGE.sideOfBridge)) {
            isUserGetTheRightAnswer = bridgeShape.caseWhenUserInputIsUpSide(bridge, idx);
        }
        if (userInput.equals(InputMatcher.DOWNSIDE_OF_BRIDGE.sideOfBridge)) {
            isUserGetTheRightAnswer = bridgeShape.caseWhenUserInputIsDownSide(bridge, idx);
        }
        return isUserGetTheRightAnswer;
    }

    private void validateInputIsUOrD(String userInput) throws IllegalArgumentException {
        if (!userInput.equals(InputMatcher.UPSIDE_OF_BRIDGE.sideOfBridge) && !userInput.equals(InputMatcher.DOWNSIDE_OF_BRIDGE.sideOfBridge)) {
            throw new IllegalArgumentException("[ERROR] U와 D만 입력할 수 있습니다.");
        }
    }

    public void retry() {
        bridgeShape.retry();
    }

    public int getSize() {
        return bridgeSize;
    }

    public List<String> getBridgeUpperSide() {
        return bridgeShape.getBridgeUpperSide();
    }

    public List<String> getBridgeDownSide() {
        return bridgeShape.getBridgeDownSide();
    }
}
