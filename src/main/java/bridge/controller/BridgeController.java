package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;

import static bridge.utils.Messages.GAME_START;

public class BridgeController {
    public void start(){
        try{
            System.out.println(GAME_START);
            BridgeGame bridgeGame = createBridgeGame();

        } catch (IllegalArgumentException e){

        }
    }

    private BridgeGame createBridgeGame(){
        int length = InputView.readBridgeSize();
        return new BridgeGame(length);
    }
}
