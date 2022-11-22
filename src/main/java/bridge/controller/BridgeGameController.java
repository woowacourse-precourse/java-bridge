package bridge.controller;

import bridge.domain.BridgeGame;
import bridge.utils.Validator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;
    int count = 1;

    int size;

    public BridgeGameController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void start(){
        inputView.printHello();
        try {
            sizeLogic();
            gameLogic();
        }
        catch(IllegalArgumentException e){
            System.out.println(e);
        }
        catch (IllegalStateException e){
            System.out.println(e);
        }
    }

    public void gameLogic(){
        boolean restartResult = true;

        while (restartResult){
            if (bridgeGame.isFinish()) break;
            boolean movingResult = moveLogic();
            if (!movingResult){
                restartResult = retryLogic();
            }
        }
        outputView.printResult(bridgeGame.getInputs(), restartResult, count);
    }

    private void sizeLogic(){
        size = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);
    }
    private boolean moveLogic(){
        String userInput = inputView.readMoving();
        boolean movingResult = bridgeGame.move(userInput);

        outputView.printMap(bridgeGame.getInputs());

        return movingResult;
    }

    private boolean retryLogic(){
        String userInput = inputView.readGameCommand();
        boolean restartResult = bridgeGame.retry(userInput);

        if (restartResult) {
            bridgeGame.init();
            count++;
        }

        return restartResult;
    }
}
