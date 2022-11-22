package bridge;

public class Application {
    private final InputView input;
    private final OutputView output;

    private Bridge bridge;
    private int tryCount = 1;

    Application() {
        this.input = new InputView();
        this.output = new OutputView();
    }

    private Bridge createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }

    private void gameStart() {
        this.output.printGameStart();
        this.output.printInputLengthRequestMessage();
        bridge = createBridge(input.readBridgeSize());
    }

    private Result nextPanels(BridgeGame game) {
        output.printSelectDirectionRequest();
        Result result = game.move(input.readMoving());
        output.printMap(bridge.getBridge(), game.getInputDirections());
        while (result.equals(Result.SAME)) {
            output.printSelectDirectionRequest();
            result = game.move(input.readMoving());
            output.printMap(bridge.getBridge(), game.getInputDirections());
        }
        return result;
    }

    private boolean restartQuestion() {
        output.printRetryQuestion();
        return input.readGameCommand().equals(RetryResponse.R);
    }

    private void endGame(BridgeGame game, boolean isSuccess) {
        output.printResultMessage();
        output.printMap(bridge.getBridge(), game.getInputDirections());
        output.printResult(isSuccess, tryCount);
    }

    private boolean gameProceed(BridgeGame game) {
        while (true) {
            Result result = nextPanels(game);
            if (result.equals(Result.CLEAR)) {
                return true;
            }
            if (result.equals(Result.WRONG)) {
                return false;
            }
        }
    }

    private void restart(BridgeGame game) {
        game.retry();
        tryCount++;
    }

    private boolean failCheck(boolean result) {
        if (!result) {
            return restartQuestion();
        }
        return false;
    }

    private boolean wholeGame(BridgeGame game) {
        boolean result = gameProceed(game);
        boolean isRestart = failCheck(result);
        if (isRestart) {
            restart(game);
            wholeGame(game);
        }
        return result;
    }

    public static void main(String[] args) {
        Application app = new Application();
        try {
            app.gameStart();
            BridgeGame game = new BridgeGame(app.bridge);
            app.endGame(game, app.wholeGame(game));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

}
