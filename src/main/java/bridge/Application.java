package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        try {
            OutputView.printMessage(GameMessage.Guide.START.getContents());
            List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
            Bridge computerBridge = new Bridge(bridge);
            BridgeGame bridgeGame = new BridgeGame(computerBridge);
            bridgeGame.playStart();
        } catch (IllegalArgumentException e) {
            //System.out.println(e.getMessage());
        }
    }
}
