package bridge;

public class Controller {
    int gameCount;
    BridgeGame bridgeGame;
    public Controller(){
        this.gameCount = 1;
        bridgeGame = new BridgeGame();
    }
    public void start(){
        OutputView.printGameStart();
        setBridgeSize();
        bridgeGame.setBridge();
        gameStart();
    }
    public void gameStart(){
        run();
        checkRetry();
    }
}
