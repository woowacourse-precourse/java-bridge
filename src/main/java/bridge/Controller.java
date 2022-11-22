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

    public void start() {
        makeBridgeGame();
        System.out.println(bridgeGame.bridge);
        boolean onGoing = true;
        String command = "";
        do {
            onGoing();
            if (bridgeGame.isSuccess) {
                break;
            }
            outputView.restartOrQuit();
            command = inputView.readGameCommand();
            if (command.equals("Q")) {
                onGoing = false;
            }
            if (command.equals("R")) {
                bridgeGame.retry();
                outputView.removeRecentBridge();
            }
        } while(onGoing);
        end();
    }

}
