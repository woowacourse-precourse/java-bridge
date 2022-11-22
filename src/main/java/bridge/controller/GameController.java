package bridge.controller;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.BridgeMaker;
import bridge.model.Answer;
import bridge.model.GameMessage;
import bridge.model.Restart;
import bridge.model.Result;
import bridge.ui.InputView;
import bridge.ui.OutputView;
import java.util.List;

public class GameController {
    private int tryCount = 1;
    private BridgeGame bridgeGame;

    public void play(){
        startGame();
        Restart restartInput = Restart.NULL;
        Answer answerInput = Answer.NONE;
        Answer answer = playAllCycle(restartInput, answerInput);
        EndGame(answer);
    }

    private void startGame(){
        InputView inputView = new InputView();
        inputView.startGame();
        bridgeMaker(inputView);
    }

    private void bridgeMaker(InputView inputView){
        String input = inputView.readBridgeSize();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        try{
            int size = bridgeMaker.getSizeInteger(input);
            bridgeGame = new BridgeGame(bridgeMaker.makeBridge(size));
        }catch (IllegalArgumentException e){
            arrangeErrorMakingBridge(inputView, e);
        }
    }

    private void arrangeErrorMakingBridge(InputView inputView, IllegalArgumentException e){
        System.out.println(e.getMessage());
        bridgeMaker(inputView);
    }
    
    private Answer playOneCycle(){
        Answer answer = validMove();
        List<List<Answer>> currentBridge = bridgeGame.getCurrentBridge(answer);
        printMap(currentBridge);
        return answer;
    }

    private Answer validMove(){
        InputView inputView = new InputView();
        String input = inputView.readMoving();
        try{
            return bridgeGame.move(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return validMove();
        }
    }

    private Answer playAllCycle(Restart restart, Answer answer){
        while (restart != Restart.FALSE) {
            answer = playOneCycle();
            restart = checkRestart(answer);
            if(restart == Restart.TRUE){
                tryCount++;
            }
        }
        return answer;
    }

    private Restart checkRestart(Answer answer){
        if(answer == Answer.CORRECT){
            return Restart.NULL;
        }
        if(answer == Answer.INCORRECT){
            return validRestart();
        }
        return Restart.FALSE;
    }

    private Restart validRestart(){
        InputView inputView = new InputView();
        String input = inputView.readGameCommand();
        try{
            return bridgeGame.retry(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return validRestart();
        }
    }

    private void EndGame(Answer answer){
        System.out.println(GameMessage.GAME_RESULT.getOutput());
        List<List<Answer>> resultBridge = bridgeGame.getCurrentBridge(answer);
        printMap(resultBridge);
        Result isSuccess = getEndCondition(answer);
        OutputView outputView = new OutputView();
        outputView.printResult(isSuccess, tryCount);
    }

    private void printMap(List<List<Answer>> result){
        OutputView outputView = new OutputView();
        outputView.printMap(result.get(0), result.get(1));
        System.out.println();
    }

    private Result getEndCondition(Answer answer){
        if(answer == Answer.END)
            return Result.SUCCESS;
        return Result.FAILED;
    }
}
