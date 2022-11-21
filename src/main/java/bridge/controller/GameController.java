package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.Result;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run(){
       int gameSize = start();
       int tryCount = 1;
       boolean isEnd = false;
       while (gameSize > 0 && !isEnd){
           String result = cycle();
           tryCount = resultRetry(result, tryCount);
           gameSize = resultCorrect(result, gameSize);
           isEnd = resultEnd(result);
       }
    }

    private String cycle(){
        boolean isSuccess = move();
        if (!isSuccess){
            if (askRetry()){
                return "retry";
            }
            return "end";
        }
        return "correct";
    }

    private int resultRetry(String result, int tryCount){
        if (result.equals("retry")){
            return tryCount + 1;
        }
        return tryCount;
    }

    private int resultCorrect(String result, int gameSize){
        if (result.equals("correct")){
            if (gameSize == 0){
                outputView.printResult();
            }
            return gameSize - 1;
        }
        return gameSize;
    }

    private boolean resultEnd(String result){
        if (result.equals("end")){
            outputView.printResult();
            return true;
        }
        return false;
    }

    private int start(){
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.start(bridgeSize);
        return bridgeSize;
    }

    private boolean move(){
        String direction = inputView.readMoving();
        List<Result> gameResults = bridgeGame.move(direction);
        boolean isSuccess = gameResults.get(gameResults.size() - 1).isSuccess();
        outputView.printMap(gameResults);
        return isSuccess;
    }


    private boolean askRetry(){
        String input = inputView.readGameCommand();
        return bridgeGame.retry(input);
    }
}
