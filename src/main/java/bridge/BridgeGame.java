package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private final List<String> correctBridge;
    // upper,bottom bridge 상태에서 1은 O, 0은 X, 2는 가지 않음을 의미한다
    List<Integer> upperBridge;
    List<Integer> bottomBridge;
    public static Integer tryCount = 1;

    public BridgeGame(List<String> correctBridge) {
        this.correctBridge = correctBridge;
        this.upperBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }

    public Boolean move(String inputMoving, String nextBridge) {
        if (correctBridge.get(tryCount).equals(inputMoving)) {
            makeBridgeSuccessState(nextBridge);
            return true;
        }
        makeBridgeFailState(nextBridge);
        return false;
    }

    public Boolean retry(String retryInput) {
        if (retryInput.equals("R")) {
            clearFailStage();
            tryCount++;
            return true;
        }
        return false;
    }

    private void makeBridgeSuccessState(String nextBridge) {
        if (checkIsUpperBridge(nextBridge)) {
            upperBridge.add(1);
        }
        bottomBridge.add(2);
    }

    private void makeBridgeFailState(String nextBridge) {
        if (checkIsUpperBridge(nextBridge)) {
            upperBridge.add(0);
        }
        bottomBridge.add(2);
    }

    private Boolean checkIsUpperBridge(String nextBridge) {
        return nextBridge.equals("U");
    }

    private void clearFailStage() {
        upperBridge.remove(upperBridge.size() - 1);
        bottomBridge.remove(bottomBridge.size() - 1);
    }

    public List<String> getCorrectBridge() {
        return correctBridge;
    }
}
