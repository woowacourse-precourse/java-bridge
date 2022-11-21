package bridge;

import java.util.List;

public class Application {
    private static final InputView receiver = new InputView();
    private static final BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public static void main(String[] args) {
        System.out.printf(Constants.Messages.START.getMessage());
        BridgeGame bridgeGame = createBridge();

    }

    // 다리를 생성
    private static BridgeGame createBridge() {
        int size = bridgeSizeUI();
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGame bridgeGame = new BridgeGame(bridge);

        return bridgeGame;
    }

    // 다리 생성 UI : 부적절한 문자가 입력될 시, 다시 입력을 받을 준비
    private static int bridgeSizeUI() {
        System.out.printf(Constants.Messages.BRIDGE.getMessage());
        while (true) {
            try {
                return receiver.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
    }
}
