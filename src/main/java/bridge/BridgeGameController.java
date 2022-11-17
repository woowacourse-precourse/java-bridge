package bridge;

public class BridgeGameController {
    InputView inputView;
    BridgeGame bridgeGame;

    int size;

    BridgeGameController(){
        inputView = new InputView();
    }
    public void start(){
        inputView.printHello();
        size = inputView.readBridgeSize();
        bridgeGame = new BridgeGame(size);

        gameLogic();
    }

    public void gameLogic(){

    }
}
