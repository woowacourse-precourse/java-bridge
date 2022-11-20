package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");

        try {
            int bridgeSize = new InputView().readBridgeSize();
            List<String> bridge = new BridgeMaker(new BridgeRandomNumberGenerator()).makeBridge(bridgeSize);
            BridgeGame bridgeGame = new BridgeGame(bridge);
            while(true) {
                if (bridgeGame.move().equals("GameOver")) break;
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
