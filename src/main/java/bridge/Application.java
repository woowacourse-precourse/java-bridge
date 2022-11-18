package bridge;

public class Application {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private boolean runGame;
    public Application(){
        inputView  = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        boolean runGame = true;
    }
    public static void main(String[] args) {
        Application application = new Application();
        while(application.runGame)
        {
            application.runGame = application.gameRun();

        }
    }

    private boolean gameRun(){
        gameInitialize();

        //after must modify Later;
        return false;
    }

    private void gameInitialize(){
        outputView.printStart();
        outputView.printInputBridgeLength();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }
    private void gameDo(){
        while(!bridgeGame.isGameOver())
        {
            inputView.readMoving();
        }
    }




}
