package bridge;

import java.util.*;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView ouputView =new OutputView();
        BridgeNumberGenerator BridgeNumberGenerator = null;
        BridgeMaker BridgeMaker = new BridgeMaker(BridgeNumberGenerator);
        int size = inputView.readBridgeSize();
        List<String> upBridge = BridgeMaker.makeBridge(size);
        List<String> downBridge = BridgeMaker.makeBridge(size);
        /*for (int i = 0; i <upBridge.size() ; i++) {
            System.out.print(upBridge.get(i));
        }*/
       ;
       ouputView.printMap(inputView.readMoving(), upBridge, downBridge);
    }
}
