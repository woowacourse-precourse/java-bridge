package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        outputView.printGameStart(); //
        bridgeGame.requestBridge();
        play(bridgeGame, outputView);
        outputView.printResult(bridgeGame);
    }
    public static void play(BridgeGame bridgeGame, OutputView outputView) {
        boolean retry = true;
        while(retry) {
            while (bridgeGame.isSuccess() && !bridgeGame.isComplete()) {
                outputView.printRequestToInputMoveCommand();
                bridgeGame.move();
                outputView.printMap(bridgeGame);
            }
            if(bridgeGame.isComplete()) {
                break;
            }
            outputView.printRequestToInputRetryCommand();
            retry = bridgeGame.retry();
        }
    }
}
