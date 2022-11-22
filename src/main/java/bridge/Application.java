package bridge;

import java.util.List;

public class Application {

    private static final String BRIDGE_GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(BRIDGE_GAME_START_MESSAGE);
        final InputView inputView = new InputView();
        final int bridgeSize = inputView.readBridgeSize();
        final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> randomBridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeController bridgeController = new BridgeController(inputView);
        bridgeController.run(bridgeSize, randomBridge);
    }
}
