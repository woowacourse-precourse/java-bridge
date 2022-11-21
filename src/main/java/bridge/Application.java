package bridge;

public class Application {
    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;
    private BridgeMaker bridgeMaker;
    private boolean runGame;

    private int tryNumber = 1;
    private String lastText = "";

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
        if (bridgeGame.isWin())
            return false;
        return judgeNewGame();
    }

    private boolean judgeNewGame() {
        outputView.printRestartMessage();
        boolean retry = bridgeGame.retry(inputView.readGameCommand());
        if (retry) {
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
        bridgeGame.gameOverChecker(bridgeGame.getNowOn());
        if (bridgeGame.isGameOver())
            return;
        outputView.printMoveBridge();
        String lastInput = inputView.readMoving();
        lastText = outputView.printMap(bridgeGame.getBridge(), bridgeGame.getNowOn(), lastInput);
        bridgeGame.move(lastInput);
    }

    public void gameResult() {
        outputView.printResult(tryNumber, lastText, bridgeGame.isWin());
    }
}
