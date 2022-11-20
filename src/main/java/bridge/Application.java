package bridge;

import java.util.*;

public class Application {
    /**
     * 게임을 시작하는 메서드
     */
    static void gameStart() {
        OutputView outputView = new OutputView();

        outputView.printStart();
    }

    /**
     * 다리 길이를 물어볼 때 사용하는 메서드
     */
    static int knowBridgeLength() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        HandleException handleException = new HandleException();

        outputView.printBridgeLength();
        String readBridgeSize = inputView.readBridgeSize();
        int checkBridgeType = handleException.checkBridgeType(readBridgeSize);
        int checkBridgeRange = handleException.checkBridgeRange(checkBridgeType);

        return checkBridgeRange;
    }

    /**
     * 다리를 만드는 메서드
     */
    static List<String> makeBridge(int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }

    /**
     * 다리를 이동하는 메서드
     */
    static void moveBridge(List<String> bridge) {
        OutputView outputView = new OutputView();

        outputView.printChoiceMove();
    }

    public static void main(String[] args) {
        try {
            Application.gameStart();
            int bridgeSize = Application.knowBridgeLength();
            List<String> bridge = Application.makeBridge(bridgeSize);
            Application.moveBridge(bridge);
        } catch (IllegalArgumentException e) {}
    }
}
