package bridge;

import java.util.List;

public class GameStarter {
    public static InputView inputView = new InputView();
    public static OutputView outputView = new OutputView();

    public GameStarter() {
        List<String> bridge = makeBridge();
        int totalCount = 1;
        while (startGame(bridge, totalCount)) {
            totalCount++;
        }
    }

    // 다리 생성 메서드
    public static List<String> makeBridge() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(size);

        return bridge;
    }
}
