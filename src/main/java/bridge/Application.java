package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> strings = bridgeMaker.makeBridge(inputView.readBridgeSize());

        BridgeGame bridgeGame = new BridgeGame(strings);

        bridgeGame.play(strings);
    }
}
