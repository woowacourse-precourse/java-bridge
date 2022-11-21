package bridge.controller;

import static bridge.util.Message.RESTART;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeGame;
import bridge.service.BridgeMaker;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private BridgeGame bridgeGame;
    private boolean flag = true;
    private int totalAttempt = 1;
    public void run(){
        outputView.startGame();

        bridgeGame = makeBridge();
        gameStart();

        outputView.printResult(bridgeGame, flag, totalAttempt);
    }

    private BridgeGame makeBridge(){
        int range = inputView.readBridgeSize();
        return new BridgeGame(bridgeMaker.makeBridge(range));
    }

    private void gameStart(){
        while (!exitGame()){
            moveBridge();
        }
    }

    private void moveBridge(){
        String input = inputView.readMoving();
        boolean result = bridgeGame.move(input);
        outputView.printMap(bridgeGame);
        if(!result)
            selectRestart();
    }

    private boolean exitGame(){
        if(flag == false || bridgeGame.getBridgeLength()-1 == bridgeGame.getBridgePoint())
            return true;
        return false;
    }

    private void selectRestart(){
        String input = inputView.readGameCommand();
        if(input.equals(RESTART)){
            bridgeGame.retry();
            totalAttempt++;
            return;
        }
        flag = false;
    }
}
