package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        printStart();
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame(bridgeSize, bridge);

        System.out.println(bridge);

        while (!bridgeGame.isEndGame()) {
            bridgeGame.move(inputView.readMoving());
        }

    }

    public static void printStart() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }
}
