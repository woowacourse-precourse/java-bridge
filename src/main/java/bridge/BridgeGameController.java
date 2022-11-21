package bridge;

import static bridge.OutputMsg.RESULT_MSG;
import static bridge.OutputView.*;
import static bridge.InputView.*;

import java.awt.desktop.SystemEventListener;

public class BridgeGameController {
    private final BridgeGame bridgeGame;

    BridgeGameController(BridgeGame bridgeGame){
        this.bridgeGame = bridgeGame;
    }

    public void run(){
        startGame();
        playGame();
        endGame();
    }

    public void startGame(){
        printStartGameMsg();
        setBridge();
    }

    void setBridge(){
        bridgeGame.setBridge(readBridgeSize());
    }

    void playGame(){
        if (bridgeGame.isPlay(InputView.readMoving())) playGame();
        if (bridgeGame.checkArrival()) return;
        if (bridgeGame.checkRetry(InputView.readGameCommand())) retryGame();
    }

    void endGame(){
        bridgeGame.printResult();
    }

    void retryGame() {
        bridgeGame.retry();
        playGame();
    }


}
