package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        InputView inputView = new InputView();
        int bridgeSize = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame();
        for (int i = 0; i < bridgeSize; i++) {
            String moving = inputView.readMoving();
            bridgeGame.move(moving, bridge);
        }
        System.out.println("끝");
    }
}
