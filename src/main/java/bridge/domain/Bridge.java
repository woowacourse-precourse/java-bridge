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

    public static boolean runMoving(BridgeGame bridgeGame, Bridge bridge) {
        boolean movingFail = true;
        List<MoveResult> moveResults = new ArrayList<>();
        while (movingFail) {
            OutputView.printMap(bridgeGame.move(bridge, moveResults));
            movingFail = bridge.currentResult;
            if (bridge.stepCount == bridge.bridge.size()) {
                return false;
            }
        }
        return true;
    }


}