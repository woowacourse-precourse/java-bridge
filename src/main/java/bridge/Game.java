package bridge;

import bridge.controller.BridgeMove;
import bridge.controller.BridgeSize;
import bridge.model.GameControll;
import bridge.view.OutputView;

public class Game {

    private final BridgeSize bridgeSize = new BridgeSize();
    private final BridgeMove bridgeMove = new BridgeMove();
    private final GameControll gameControll = new GameControll();
    private final OutputView outputView = new OutputView();

    public void play(){
        outputView.printStart();
        bridgeSize.viewBridgeSize();
        playBridgeGame();
    }

    public void playBridgeGame(){
        while(gameControll.getGamePower()){
            bridgeMove.movebridge();
        }
    }
}
