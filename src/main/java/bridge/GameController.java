package bridge;


import bridge.View.InputView;
import bridge.View.OutputView;

import static bridge.Constant.Command.RETRY;
import static bridge.Constant.GameStatus.*;
import static bridge.Constant.Message.*;

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
                askRetry();
            }
        }
        outputView.printResult(bridgeGame);
    }

    private void playOneStage(){
        while(bridgeGame.getStatus() == STATUS_PLAY){
            System.out.println(MSG_GET_MOVING);
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.getCurBridge());
        }
    }

    private void askRetry(){
        System.out.println(MSG_GET_RETRY);
        String isRetry = inputView.readGameCommand();
        if(isRetry.equals(RETRY)){
            bridgeGame.retry();
        }
    }

}
