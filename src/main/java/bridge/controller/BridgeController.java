package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Result;
import bridge.view.InputView;

import static bridge.utils.Messages.GAME_START;

public class BridgeController {
    public void start(){
        try{
            BridgeGame bridgeGame = createBridgeGame();
            Result result = movePlayer(bridgeGame);
            printResult(result);
        } catch (IllegalArgumentException e){

        }
    }

    private BridgeGame createBridgeGame(){
        System.out.println(GAME_START);
        int length = InputView.readBridgeSize();
        return new BridgeGame(length);
    }
    private Result movePlayer(BridgeGame bridgeGame){
        for(int i=0;i<bridgeGame.getLength();i++) {
            if(!bridgeGame.move(InputView.readMoving(),i)){
                i = bridgeGame.retry(InputView.readGameCommand());
            }
        }
        return new Result(bridgeGame.isDone(),bridgeGame.getAttemptCount());

    }

    private void printResult(Result result){

    }
}
