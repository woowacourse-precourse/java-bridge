package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private static int stepCount = 0;
    boolean currentResult = false;
    public Bridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
    }

    public boolean checkIfItCanBeMoved(MoveSpace moveSpace){
        String nowStep = this.bridge.get(this.stepCount);
        this.currentResult = false;
        if(moveSpace.isItMovable(nowStep)){
            nextStep();
            this.currentResult = true;
        }
        return currentResult;
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

    public MoveResult createMoveResult(MoveSpace movespace){
        String currentStep = this.bridge.get(this.stepCount);
        String currentMove = movespace.getMove();
        boolean currentResult = false;
        if (movespace.isItMovable(currentStep)) {
            currentResult = true;
        }
        return new MoveResult(currentResult, currentMove);
    }
}