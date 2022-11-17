package bridge;

import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    static BridgeGame bridgeGame = new BridgeGame();
    static final String startGame = "다리 건너기 게임을 시작합니다.\n";
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(startGame);
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        System.out.println();
        bridgeGame.move(0, bridgeList, 0, "");
    }
}
