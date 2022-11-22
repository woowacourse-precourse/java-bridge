package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private static int stepCount;

    public Bridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
        this.stepCount = 0;
;    }

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
}