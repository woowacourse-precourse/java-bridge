package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.GameStatus.STATUS_FAIL;
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
            if(bridgeGame.getStatus() == STATUS_FAIL){

            }
        }
    }

    private void playOneStage(){
        List<List<String>> curBridge;
        while(bridgeGame.getStatus() == STATUS_PLAY){
            System.out.println(MSG_GET_MOVING);
            curBridge = bridgeGame.move(inputView.readMoving());
            outputView.printMap(curBridge);
        }
    }

    private void askRetry(){
        System.out.println(MSG_GET_RETRY);
        String isRetry = inputView.readGameCommand();
    }

}
