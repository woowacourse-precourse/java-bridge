package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker= new BridgeMaker(bridgeRandomNumberGenerator);
    public static List<Integer> main_Bridge = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int len = InputView.readBridgeSize();
        bridgeMaker.makeMainBridge(len);
        System.out.println(main_Bridge);
    }
}
