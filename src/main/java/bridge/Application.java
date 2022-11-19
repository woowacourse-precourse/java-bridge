package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.*;

public class Application {

    public static void main(String[] args) {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int size = inputBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> generatedBridge = bridgeMaker.makeBridge(size);
        wholeGame(generatedBridge);
    }
}