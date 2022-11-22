package bridge;

public class BridgeApp {

    private static int count = 1;

    private final BridgeMaker bridgeMaker;
    private final OutputView outputView;
    private final InputView inputView;
    private BridgeGame bridgeGame;

    private String move;
    private String command;

    public BridgeApp() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.move = "";
        this.command = "";
    }

    public void run() {
        startGame();
        while (true) {
            moveOnBridge();
            int arrive = bridgeGame.move(move);
            outputView.printMap(bridgeGame.getUp(), bridgeGame.getDown());
            if (checkGame(bridgeGame, arrive) == 0) {
                return;
            }
        }
    }

    public void startGame() {
        int bridgeSize = -1;
        while (bridgeSize < 3 || bridgeSize > 20) {
            bridgeSize = inputView.readBridgeSize();
        }
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(bridgeSize), bridgeSize);
    }

    public void moveOnBridge() {
        do {
            move = inputView.readMoving();
        } while (move.equals("[ERROR]"));
    }

    public int checkGame(BridgeGame bridgeGame, int arrive) {
        int result = -1;
        if (arrive == 1) {
            result = winGame(bridgeGame);
        } else if (arrive == -1) {
            result = retryGame(bridgeGame);
        }
        return result;
    }

    private int winGame(BridgeGame bridgeGame) {
        outputView.printResult(bridgeGame, count);
        return 0;
    }

    private int retryGame(BridgeGame bridgeGame) {
        endOrRetryGame();
        if (command.equals("Q")) {
            outputView.printResult(bridgeGame, count);
            return 0;
        }
        if (command.equals("R")) {
            bridgeGame.retry();
            count++;
        }
        return -1;
    }

    private void endOrRetryGame() {
        do {
            command = inputView.readGameCommand();
        } while (command.equals("[ERROR]"));
    }
}
