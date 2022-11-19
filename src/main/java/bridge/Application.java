package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeGame bridgeGame = new BridgeGame();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int inputNumber = inputView.readBridgeSize();
        List<String> bridgeList = new BridgeMaker(bridgeRandomNumberGenerator).makeBridge(inputNumber);
        //최초 1회 구현

        bridgeGame.move(bridgeList);



    }
}
