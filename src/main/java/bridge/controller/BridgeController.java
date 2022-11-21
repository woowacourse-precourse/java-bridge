package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.Messages.ASK_RETRY;
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
            i = move(bridgeGame,i);
        }
        return new Result(bridgeGame.isDone(),bridgeGame.getAttemptCount());
    }

    private int move(BridgeGame bridgeGame, int index){
        if(!bridgeGame.move(InputView.readMoving(),index)){
            OutputView.printMapFail(index,bridgeGame.getBridge());
            return bridgeGame.retry(InputView.readGameCommand());
        }
        OutputView.printMap(index,bridgeGame.getBridge());
        return index;
    }


    private void printResult(Result result){

    }
}
