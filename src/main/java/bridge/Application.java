package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = InputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        List<String> nowBridge = new ArrayList<>();
        InputView.readMoving(nowBridge);
    }
}