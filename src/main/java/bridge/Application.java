package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        ready(bridgeGame, outputView);
        play(bridgeGame, outputView);
        outputView.printResult(bridgeGame);
    }
    public static void ready(BridgeGame bridgeGame, OutputView outputView) {
        outputView.printGameStart();
        bridgeGame.requestBridge();
    }
    public static void play(BridgeGame bridgeGame, OutputView outputView) {
        while (bridgeGame.isSuccess() && !bridgeGame.isComplete()) {
            move(bridgeGame, outputView);
        }
        if(bridgeGame.isComplete()) {
            return;
        }
        retry(bridgeGame, outputView);
    }
    public static void move(BridgeGame bridgeGame, OutputView outputView) {
        outputView.printRequestToInputMoveCommand();
        bridgeGame.move();
        outputView.printMap(bridgeGame);
    }
    public static void retry(BridgeGame bridgeGame, OutputView outputView) {
        outputView.printRequestToInputRetryCommand();
        if(bridgeGame.retry()) {
            play(bridgeGame, outputView);
        }
    }
}
