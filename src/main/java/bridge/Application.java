package bridge;

public class Application {

    public static void main(String[] args) {
        BridgeGame bridgeGame = new BridgeGame();
        OutputView outputView = new OutputView();
        outputView.printGameStart();
        bridgeGame.requestBridge();
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
            retry = bridgeGame.retry(); // 재시도
        }
        outputView.printResult(bridgeGame);
    }
}
