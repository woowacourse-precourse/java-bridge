package bridge;

import static bridge.GameStatus.STATUS_PLAY;
import static bridge.Message.MSG_START;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void startGame(){
        System.out.println(MSG_START);
        BridgeGame bridgeGame = new BridgeGame(inputView.readBridgeSize());
        while(bridgeGame.getStatus() == STATUS_PLAY){
            playOneStage();
        }
    }

    private void playOneStage(){
        // for
        // get input U or D
        // move
        //
    }

}
