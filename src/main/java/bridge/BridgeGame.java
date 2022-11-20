package bridge;

import java.util.List;

public class BridgeGame {

    private final List<String> correctBridge;
    // upper,bottom bridge 상태에서 1은 O, 0은 X, 2는 가지 않음을 의미한다
    private List<Integer> upperBridge;
    private List<Integer> bottomBridge;

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
    }

    public Boolean move(String inputMoving, String nextBridge) {
        if (nextBridge.equals(inputMoving)) {

            return true;
        }
        return false;
    }

    public Boolean retry(String retryInput) {
        return retryInput.equals("R");
    }

    private void makeBridgeSuccessState(String nextBridge) {
        if (checkUpperBridge(nextBridge)) {
            upperBridge.add(1);
        }
        bottomBridge.add(2);
    }

    private void makeBridgeFailState(String nextBridge) {
        if (checkUpperBridge(nextBridge)) {
            upperBridge.add(0);
        }
        bottomBridge.add(2);
    }

    private Boolean checkUpperBridge(String nextBridge) {
        return nextBridge.equals("U");
    }
}
