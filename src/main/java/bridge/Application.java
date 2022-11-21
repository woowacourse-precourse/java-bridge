package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.gameStart();
        int size = bridgeGame.requestBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(size);

        for(String str : bridge){
            System.out.printf(str + " ");
        }

        OutputView outputView = new OutputView();
        outputView.printGoDown(bridge, "U", 0);
    }
}
