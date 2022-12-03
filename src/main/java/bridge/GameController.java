package bridge;

public class GameController {


    private BridgeValid bridgeGame = new BridgeValid();
    private InputView inputView = new InputView();

    public void Game() {
        GameStart();
        setBridge();
        lootBridge();
        result();
        Score();
    }

    public void GameStart() {
        System.out.println(Command.START_MESSAGE + "\n" +Command.LENGTH_MESSAGE+ "\n");

    }
    public void setBridge(){
        bridgeGame.useBridge();
    }
    public void lootBridge(){
        bridgeGame.loop();
    }
    public void result(){
        bridgeGame.totalResult();
    }
    public void Score(){
        bridgeGame.ScoreCount();
    }
}
