package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import java.util.ArrayList;
import java.util.List;

public class Bridge {

    public final List<String> bridge;
    public static int stepCount = 0;
    boolean currentResult = false;
    public Bridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(size);
        System.out.println(bridge);
    }

    public MoveResult createMoveResult(MoveSpace moveSpace){
        String nowStep = this.bridge.get(this.stepCount);
        this.currentResult = false;
        if(moveSpace.isItMovable(nowStep)){
            nextStep();
            this.currentResult = true;
        }
        return new MoveResult(currentResult, nowStep);
    }

    public void nextStep(){
        this.stepCount +=1;
    }

    public boolean getCurrentResult(){
        return this.currentResult;
    }
}