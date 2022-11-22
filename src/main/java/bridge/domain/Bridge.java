package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private List<String> bridge;
    private static int stepCount;
    private final int size;

    public Bridge(int size) {
        this.size = size;
        makeBridgeBySize(this.size);

        this.stepCount = 0;
;    }

    private void makeBridgeBySize(int size) {
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
    }

    public MoveResult createMoveResult(MoveSpace moveSpace){
        String currentStep = this.bridge.get(this.stepCount);
        boolean currentResult = false;
        String currentMove = moveSpace.getMove();
        if(moveSpace.isItMovable(currentStep)){
            currentResult = true;
        }
        return new MoveResult(currentResult, currentMove);
    }

    public void nextStep(){
        this.stepCount +=1;
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