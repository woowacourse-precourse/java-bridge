package bridge.controller;

import bridge.InputView;
import bridge.view.Print;

public class BridgeGameController {

    public static void setGame(){
        Print.gameStartMessage();

        Print.requestBridgeLengthMessage();
        try{
            InputView inputView = new InputView();
            int bridgeSize = inputView.readBridgeSize();
        }catch (IllegalArgumentException e){
            Print.exceptionMessage(e);
        }



    }
}
