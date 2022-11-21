package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeController bridgeController = new BridgeController();
        BridgeGame bridgeGame = bridgeController.doBridgeMake();

        while (true){
            if(!bridgeController.doBridgeMove(bridgeGame)){

            }
        }
    }
}
