package bridge;

import ui.InputView;
import ui.OutputView;

public class BridgeGameController {
    private final boolean NOT_OVER = false;
    private final boolean FAIL = true;

    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    public BridgeGameController(){
        inputView = new InputView();
        outputView = new OutputView();
        outputView.printGameStartMessage();
        bridgeGame = new BridgeGame(inputView.readBridgeSize());
    }
    public void run(){
        startGame();
        endGame();
    }
    private void startGame(){
        while(bridgeGame.isCorrect() == NOT_OVER){
            bridgeGame.move(inputView.readMoving());
            outputView.printMap(bridgeGame.lastMoveToString());
            if(bridgeGame.isGameOver() == FAIL){
                bridgeGame.retry(inputView.readGameCommand());
            }
        }
    }
    private void endGame(){
        outputView.printFinalGameMap(bridgeGame.lastMoveToString());
        outputView.printResult(bridgeGame.isCorrect());
        outputView.printGameTryResultMessage(bridgeGame.userTry());
    }
}
