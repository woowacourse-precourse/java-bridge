package bridge;

import java.util.List;

public class Application {
    private InputView input;
    private OutputView output;

    private BridgeGame bridgeGame;

    Application(){
        this.input = new InputView();
        this.output = new OutputView();
    }

    private Bridge createBridge(int size){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return new Bridge(bridgeMaker.makeBridge(size));
    }
    private void gameStart(){
        this.output.printGameStart();
        this.output.printInputRequestMessage();
        int size = this.input.readBridgeSize();
        this.bridgeGame = new BridgeGame(createBridge(size));
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.gameStart();
        // TODO: 프로그램 구현
    }
}
