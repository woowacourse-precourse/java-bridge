package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {
    BridgeMaker bridgeMaker;
    private final List<String> correctBridge;
    // upper,bottom bridge 상태에서 1은 O, 0은 X, 2는 가지 않음을 의미한다
    List<Integer> upperBridge;
    List<Integer> bottomBridge;
    public static Integer tryCount = 1;
    private Integer bridgeCount = 0;

    public BridgeGame(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.correctBridge = bridgeMaker.makeBridge(size);
        this.upperBridge = new ArrayList<>();
        this.bottomBridge = new ArrayList<>();
    }

    public Boolean move(String inputMoving) {
        bridgeCount++;
        String nextBridge = correctBridge.get(bridgeCount - 1);
        if (nextBridge.equals(inputMoving)) {
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
            bottomBridge.add(2);
            return;
        }
        upperBridge.add(2);
        bottomBridge.add(1);
    }

    private void makeBridgeFailState(String nextBridge) {
        if (checkIsUpperBridge(nextBridge)) {
            upperBridge.add(0);
            bottomBridge.add(2);
            return;
        }
        upperBridge.add(2);
        bottomBridge.add(0);
    }

    private Boolean checkIsUpperBridge(String nextBridge) {
        return nextBridge.equals("U");
    }

    private void clearFailStage() {
        upperBridge.remove(upperBridge.size() - 1);
        bottomBridge.remove(bottomBridge.size() - 1);
    }
}
