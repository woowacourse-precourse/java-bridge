package bridge.domain;

import static bridge.view.SystemMessage.BRIDGE_SIZE_LIMIT_ERROR_MESSAGE;
import static bridge.view.SystemMessage.ERROR_MESSAGE;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private static int stepCount;
    private final int size;

    public Bridge(String size) {

        this.size = validateLimit(validateNumber(size));
        makeBridgeBySize(this.size);

        this.stepCount = 0;
        ;
    }

    private static Integer validateNumber(String size) {
        return Integer.parseInt(size);
    }

    private static int validateLimit(int size) {
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException(ERROR_MESSAGE + BRIDGE_SIZE_LIMIT_ERROR_MESSAGE);
        }
        return size;
    }
    private void makeBridgeBySize(int size) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public MoveResult createMoveResult(MoveSpace moveSpace) {
        String currentStep = this.bridge.get(this.stepCount);
        boolean currentResult = false;
        String currentMove = moveSpace.getMove();
        if (moveSpace.isItMovable(currentStep)) {
            currentResult = true;
        }
        return new MoveResult(currentResult, currentMove);
    }

    public void nextStep() {
        this.stepCount += 1;
    }

    public boolean isCurrentMovable(List<MoveResult> moveResults) {
        if (moveResults.get(this.stepCount).isSuccessMove()) {
            return true;
        }
        return false;
    }

    public boolean crossingBridgeSuccess() {
        if (this.stepCount < this.bridge.size()) {
            return true;
        }
        return false;
    }

    public void resetStep() {
        this.stepCount = 0;
    }

}