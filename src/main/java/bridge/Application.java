package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController();

        bridgeController.startGame();
        List<String> bridge = bridgeController.bridgeMake();
        for(String str : bridge){
            System.out.printf(str + " ");
        }
        bridgeController.playBridgeGame(bridge);
    }
}
