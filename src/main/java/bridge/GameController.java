package bridge;

import static bridge.GameStatus.STATUS_PLAY;
import static bridge.Message.*;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;

    public void startGame(){
        System.out.println(MSG_START);
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while(bridgeGame.getStatus() == STATUS_PLAY){
            playOneStage();
            //retry?
        }
    }

    private void playOneStage(){
        while(bridgeGame.getStatus() == STATUS_PLAY){
            System.out.println(MSG_GET_MOVING);
            bridgeGame.move(inputView.readMoving());
        }
    }

}
