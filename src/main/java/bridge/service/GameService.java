package bridge.service;

import bridge.domain.*;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.vo.Commend;

public class GameService {

    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameStart() {
        outputView.printStartMessage();
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.setGameStart(bridgeSize);
    }

    public void runGame() {
        outputView.printMoveChooseMessage();
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame);
        checkResult();
    }

    private void checkResult() {
        if(bridgeGame.gameOver())
            return;
        if(bridgeGame.roundClear()) {
            runGame();
            return;
        }
        if(!bridgeGame.roundClear())
            chooseRetry();
    }

    private void chooseRetry() {
        outputView.printChooseRetry();
        String retry = inputView.readGameCommand();
        if(retry.equals(Commend.RETRY)){
            bridgeGame.retry();
            runGame();
        }
    }

    public void endGame() {
        outputView.printResult(bridgeGame);
    }
}
