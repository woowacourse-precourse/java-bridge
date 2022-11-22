package bridge.controller;

import bridge.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.enums.GameStatus.QUIT;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame;

    public BridgeGameController(){
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }

    private void moveAStep(){
        outputView.printMap(bridgeGame.move(inputView.readMoving()));
    }

    private void resetGame(){
        bridgeGame.retry();
    }

    private void concludeGame(){
        outputView.printResult(bridgeGame.constructBridge(),
                bridgeGame.getTotalTrialCount());
    }

    public void runGame(){
        while(true){
            moveUntilStop();
            if(bridgeGame.isSuccess()) break;
            if(isQuit())break;
            resetGame();
        }
        concludeGame();
    }

    private boolean isQuit(){
        return readFinalCommand().equals(QUIT.getCommand());
    }

    private void moveUntilStop(){
        while(!(bridgeGame.isSuccess()) || bridgeGame.isPaused()){
            moveAStep();
        }
    }

    private String readFinalCommand(){
        return inputView.readGameCommand();
    }
}
