package bridge;

import java.util.List;

import static bridge.Check.checkBridge;

public class Application {
    private static InputView inputView;
    private static BridgeMaker bridgeMaker;

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
    }
}
