package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;

public class BridgeController {
    public void start(){
        try{

            BridgeGame bridgeGame = createBridgeGame();
        } catch (IllegalArgumentException e){

        }
    }

    private BridgeGame createBridgeGame(){
        int length = InputView.readBridgeSize();
        return new BridgeGame(length);
    }
}
