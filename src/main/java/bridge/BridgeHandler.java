package bridge;

import java.util.List;
import java.util.ArrayList;

public class BridgeHandler {
    public void run(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean result = moveStep(bridgeGame);
        System.out.println("The result is " + result);
    }

    public boolean moveStep(BridgeGame bridgeGame){
        int bridgeSize = bridgeGame.getBridgeSize();
        boolean stepResult;
        System.out.println("bridgeSize: " + bridgeSize);
        List<String> trace = new ArrayList<>(bridgeSize);
        String updown;
        for (int step = 0; step < bridgeSize; step++) {
            updown = InputView.readMoving();
            trace.add(updown);
            System.out.println("updown: " + updown);

            stepResult = bridgeGame.move(updown, step);
            System.out.println(stepResult);
            if(!stepResult){
//                OutputView.printMap(trace, false);
//                return false;
                System.out.println("Failed!");
                return false;
            }
//            OutputView.printMap(trace, true);
        }
        return true;
    }
}
