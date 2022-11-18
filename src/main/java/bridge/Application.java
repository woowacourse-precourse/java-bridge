package bridge;

import bridge.view.InputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(5);
        for (String s : bridge) {
            System.out.println(s);
        }
        System.out.println(bridge.size());
    }
}
