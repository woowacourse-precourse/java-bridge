package bridge;

public class Application {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private boolean runGame;
    private int tryNumber = 0;

    public Application() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        boolean runGame = true;
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.gameInitialize();
        while (application.runGame) {
            application.runGame = application.gameRun();
        }
    }

    private boolean gameRun() {
        while (!bridgeGame.isGameOver()) {
            gameDo();
        }
        //after must modify Later;
        return false;
    }

    private void gameInitialize() {
        outputView.printStart();
        outputView.printInputBridgeLength();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private void gameDo() {
        outputView.printMoveBridge();
        String lastInput = inputView.readMoving();
        bridgeGame.move(lastInput);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getNowOn(), lastInput);
    }


}
