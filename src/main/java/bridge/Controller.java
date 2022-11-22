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

    public void stepForward(boolean isRetry) {
        bridgeGame.move(getMoving());
        outputView.drawMap(bridgeGame, isRetry);
        outputView.printMap();
    }

    public void end() {
        outputView.printResult(bridgeGame);
    }

    public void onGoing(Boolean isRetry) {
        do {
            stepForward(isRetry);
            isRetry = false;
            if (bridgeGame.getIsCorrect() == false) {
                isRetry = true;
            }
            if (bridgeGame.isSuccess) {
                break;
            }
        }
        while (!isRetry);
    }

    public void start() {
        makeBridgeGame();

        // 테스트용
        System.out.println(bridgeGame.bridge);
        // @@@@@@

        boolean onGoing = true;
        boolean isRetry = false;
        String command = "";
        do {
            onGoing(isRetry);
            if (bridgeGame.isSuccess) {
                break;
            }
            outputView.restartOrQuit();
            command = inputView.readGameCommand();
            if (command.equals("Q")) {
                onGoing = false;
            }
            if (command.equals("R")) {
                isRetry = true;
                bridgeGame.retry();
            }
        } while(onGoing);
        end();
    }

}
