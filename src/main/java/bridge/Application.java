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
        BridgeGame BridgeGame = new BridgeGame();
        int index = 0;
       while(size > 0){
           String move = BridgeGame.move(inputView.readMoving());
           if(move.charAt(0) == 'U'){
               upBridge = BridgeMaker.bridgeAddMove(move , upBridge);
               downBridge =  BridgeMaker.bridgeAddElseMove(downBridge);
               ouputView.printMap(move, upBridge, downBridge);
           }else {
               downBridge = BridgeMaker.bridgeAddMove(move , downBridge);
               upBridge = BridgeMaker.bridgeAddElseMove(upBridge);
               ouputView.printMap(move, upBridge, downBridge);
           }
           size--;
           if(move.charAt(1) == 'X'){
               break;
           }
           String retryGame = inputView.readGameCommand();
       }
    }
}
