package bridge;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public Controller() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void start() {
        makeBridgeGame();
        do {
            onGoing();
        } while (!bridgeGame.isSuccess && !isQuit());
        end();
    }

    public void makeBridgeGame() {
        outputView.printStartGame();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
    }

    public void onGoing() {
        do {
            stepForward();
        } while (bridgeGame.getIsCorrect() && !bridgeGame.isSuccess);
    }

    public void stepForward() {
        bridgeGame.move(getMoving());
        outputView.makeBridgeMap(bridgeGame);
        outputView.printMap();
    }

    public void end() {
        outputView.printResult(bridgeGame);
    }

    public boolean isQuit() {
        String command = getCommand();
        if (command.equals("Q")) {
            return true;
        }
        bridgeGame.retry();
        outputView.removeRecentBridge();
        return false;
    }

    public int getBridgeSize() {
        outputView.inputBridgeSize();
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public String getMoving() {
        outputView.inputMoving();
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }

    public String getCommand() {
        outputView.inputCommand();
        while (true) {
            try {
                return inputView.readGameCommand();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
