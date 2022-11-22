package bridge.controller;


import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeJudgment;
import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.views.InputView;
import bridge.views.OutputView;

import java.util.List;

public class BridgeController {

    public static int I = 0;
    public static int BRIDGE_SIZE = InputView.readBridgeSize();
    public static BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();

    public static BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    public static List<String> resultBridge = bridgeMaker.makeBridge(BRIDGE_SIZE);



    public void printMapGenerator() {
        for(int i=0; i<BRIDGE_SIZE; i++) {
            OutputView.printMap();
        }
    }

    public int intCount() {
        I += 1;
        return I;
    }


    public boolean playerStatus() {

        return BridgeJudgment.judgmentMoving(resultBridge, intCount());
    }

}
