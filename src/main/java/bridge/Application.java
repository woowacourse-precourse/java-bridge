package bridge;

public class Application {
    static InputView inputView;
    static OutputView outputView;
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    static BridgeMaker bridgeMaker;
    static BridgeGame bridgeGame;

    public static void main(String[] args) {
        try {
            startState();
            gameState();
            endState();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void startState() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        bridgeGame = new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        inputView = new InputView(bridgeGame);
        outputView = new OutputView();
    }

    private static void gameState() {
        while (!bridgeGame.isGameEnd()) {
            inputView.readMoving();
            outputView.printMap(bridgeGame.getUpperRoad(), bridgeGame.getLowerRoad());
            if (!bridgeGame.isRightFoothold()) {
                if (inputView.readGameCommand().equals(Command.QUIT.getValue())) {
                    break;
                }
                bridgeGame.retry();
            }
        }
    }

    private static void endState() {
        outputView.printResult(bridgeGame);
    }
}
