package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();


        bridgeGame.gamePlay();
//        bridgeMaker.makeBridge(4);
//        bridgeGame.move(test1, test2, test3);

    }
}
