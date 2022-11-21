package bridge;

import static bridge.InputView.readBridgeSize;

public class Application {

    public static void main(String[] args) {
        try {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

            OutputView.String("다리 건너기 게임을 시작합니다.");
            BridgeGame bridgeGame = new BridgeGame(bridgeMaker.makeBridge(readBridgeSize()));
        } catch (IllegalArgumentException e) {
        }

    }
}
