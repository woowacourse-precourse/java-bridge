package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static String printGameStart = "다리 건너기 게임을 시작합니다.";
    static BridgeNumberGenerator bridgeNumberGenerator;
    static List<String> bridge = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(printGameStart);
        InputView inputView = new InputView();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());


    }
}
