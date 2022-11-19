package bridge;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        InputView inputView = new InputView();

        try {
            OutputView.printMessage(GameMessage.Guide.START.getContents());
            int size = inputView.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            Bridge computerBridge = new Bridge(bridge);
            BridgeGame bridgeGame = new BridgeGame(computerBridge);
            bridgeGame.playStart();
        } catch (Exception e) {

        }

    }
    private static void play() {

    }
}
