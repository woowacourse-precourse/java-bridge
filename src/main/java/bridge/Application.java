package bridge;

public class Application {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private boolean runGame;

    private int tryNumber = 1;

    public Application() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        runGame = true;
    }

    public static void main(String[] args) {
        Application application = new Application();
        application.gameInitialize();
        while (application.runGame) {
            application.runGame = application.gameRun();
        }
        application.gameResult();
    }

    private boolean gameRun() {
        while (!bridgeGame.isGameOver()) {
            gameDo();
        }
        return judgeNewGame();
    }

    private boolean judgeNewGame(){
        boolean retry = bridgeGame.retry(inputView.readGameCommand());
        if(retry)
        {
            tryNumber++;
            return true;
        }
        return false;
    }

    private void gameInitialize() {
        outputView.printStart();
        outputView.printInputBridgeLength();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private void gameDo() {
        outputView.printMoveBridge();
        bridgeGame.gameOverChecker(bridgeGame.getNowOn());
        String lastInput = inputView.readMoving();
        bridgeGame.move(lastInput);
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getNowOn(), lastInput);
    }

    public void gameResult(){
        outputView.printResult(tryNumber,bridgeGame.getBridge(),bridgeGame.isWin());
    }
}
