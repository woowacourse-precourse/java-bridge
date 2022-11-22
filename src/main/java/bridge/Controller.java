package bridge;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    public Controller() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public int getBridgeSize() {
        outputView.inputBridgeSize();
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    public String getMoving() {
        outputView.inputMoving();
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    public void makeBridgeGame() {
        outputView.printStartGame();
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(getBridgeSize()));
    }

    public void stepForward() {
        bridgeGame.move(getMoving());
        outputView.makeBridgeMap(bridgeGame);
        outputView.printMap();
    }

    public void end() {
        outputView.printResult(bridgeGame);
    }

    public void onGoing() {
        do {
            stepForward();
            if (bridgeGame.getIsCorrect() == false) {
                break;
            }
            if (bridgeGame.isSuccess) {
                break;
            }
        } while (true);
    }

    public boolean isQuit() {
        outputView.restartOrQuit();
        if (inputView.readGameCommand().equals("Q")) {
            return true;
        }
        bridgeGame.retry();
        outputView.removeRecentBridge();
        return false;
    }

    public void start() {
        makeBridgeGame();
        System.out.println(bridgeGame.bridge);
        do {
            onGoing();
            if (bridgeGame.isSuccess) {
                break;
            }
            if (isQuit()) {
                break;
            }
        } while(true);
        end();
    }
}
