package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Message.start();
        int bridgeLength = InputView.readBridgeSize();
        List<Integer> bridge = makeBridge(bridgeLength);
        System.out.print("현재 다리 : ");
        for(int i=0; i<bridge.size(); i++){
            System.out.print(bridge.get(i) + " ");
        }
    }

    public static List<Integer> makeBridge(int bridgeLength) {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        List<Integer> bridge = new ArrayList<>();

        for(int i=0; i<bridgeLength; i++) {
            bridge.add(bridgeRandomNumberGenerator.generate());
        }

        return bridge;
    }
}