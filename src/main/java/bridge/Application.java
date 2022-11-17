package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();
        List<String> test1 = new ArrayList<>();
        test1.add("U");
        test1.add("D");
        test1.add("U");
        List<String> test2 = new ArrayList<>();
        test2.add("U");
        test2.add("D");
        System.out.println(test1.getClass().getName());
        System.out.println(test2.getClass().getName());
        String test3 = "U";

//        bridgeMaker.makeBridge(4);
        bridgeGame.move(test1, test2, test3);

    }
}
