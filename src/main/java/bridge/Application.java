package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        try {
            System.out.println("다리 건너기 게임을 시작합니다.");
            InputView playerInput = new InputView();
            int size = playerInput.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(size);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
