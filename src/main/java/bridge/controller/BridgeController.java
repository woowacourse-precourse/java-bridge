package bridge.controller;

import bridge.model.BridgeGame;
import bridge.model.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.utils.Exceptions.USER_INPUT_OUT_OF_RANGE_EXCEPTION;
import static bridge.utils.Messages.ASK_RETRY;
import static bridge.utils.Messages.GAME_START;

public class BridgeController {
    public void start(){
        try{
            BridgeGame bridgeGame = createBridgeGame();
            Result result = movePlayer(bridgeGame);
            printResult(result,bridgeGame);
        } catch (IllegalArgumentException e){
            OutputView.printException(e);
        }
    }

    private BridgeGame createBridgeGame(){
        System.out.println(GAME_START);
        int length = InputView.readBridgeSize();
        if(length<3||length>20){
            throw new IllegalArgumentException(USER_INPUT_OUT_OF_RANGE_EXCEPTION);
        }
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
            return bridgeGame.retry(InputView.readGameCommand(),index);
        }
        OutputView.printMap(index,bridgeGame.getBridge());
        return index;
    }


    private void printResult(Result result, BridgeGame bridgeGame){
        OutputView.printResult(result,bridgeGame);
    }
}
