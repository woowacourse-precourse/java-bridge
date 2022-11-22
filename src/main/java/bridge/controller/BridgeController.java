package bridge.controller;


import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeJudgment;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.views.InputView;
import bridge.views.OutputView;

import java.util.List;

public class BridgeController {

    private static final int BRIDGE_SIZE = ;
    public static int I = 0;
    
    public static BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    public static BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    public List<String> resultBridge = bridgeMaker.makeBridge(BRIDGE_SIZE);



    public void printMapGenerator() {
        InputView inputView = new InputView();
        int BRIDGE_SIZE = inputView.readBridgeSize();
        
        for(int i=0; i<BRIDGE_SIZE; i++) {
            OutputView.printMap();
        }
    }

    public int intCount() {
        I += 1;
        return I;
    }


    public boolean playerStatus() {

        List<String> resultBridge = bridgeMaker.makeBridge(BRIDGE_SIZE);

        return BridgeJudgment.judgmentMoving(resultBridge, intCount());
    }

}
