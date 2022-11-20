package bridge;

public class Application {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker newBridge = new BridgeMaker(new BridgeRandomNumberGenerator());

    public static void main(String[] args) {
        Application app = new Application();
        BridgeGame newGame = app.settingGame();
        app.runningGame(newGame);
        app.closingGame(newGame);
    }

    public BridgeGame settingGame() {
        output.printGameStart();
        output.printAskBridgeSize();
        return new BridgeGame(newBridge.makeBridge(input.readBridgeSize()));
    }

    public void runningGame(BridgeGame game) {
        boolean playing = true;
        while (playing) {
            playing = moving(game);
            output.printMap(game.bridge, game.moveResult);
            if (!playing) {
                playing = playAgain(game);
            }
        }
    }

    public void closingGame(BridgeGame game) {
    }

    private boolean moving(BridgeGame game){
        output.printAskMovement();
        return game.move(input.readMoving());
    }

    private boolean playAgain(BridgeGame game){
        output.printAskRetry();
        return game.retry(input.readGameCommand());
    }
}
