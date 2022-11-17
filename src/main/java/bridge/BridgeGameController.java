package bridge;

public class BridgeGameController {
    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;

    int size;

    BridgeGameController(){
        inputView = new InputView();
        outputView = new OutputView();
    }
    public void start(){
        inputView.printHello();
        size = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);

        gameLogic();
    }

    public void gameLogic(){
        boolean restartResult = true;

        while (restartResult){
            if (bridgeGame.isFinish()) break;
            boolean movingResult = bridgeGame.move();

            if (!movingResult){
                restartResult = bridgeGame.retry();
            }
        }
        outputView.printResult();
    }
}
