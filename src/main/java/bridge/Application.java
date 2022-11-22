package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGameController controller = new BridgeGameController();

        controller.gameStart();

        List<String> bridge = controller.makeBridge();

        controller.playGame(bridge);

        controller.printResult(bridge,bridge.size());
    }

}
