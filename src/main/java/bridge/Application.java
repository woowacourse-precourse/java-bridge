package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();
    static BridgeRandomNumberGenerator br = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(br);
    static BridgeController bridgeController = new BridgeController();

    private static List<String> bridge = new ArrayList<>();
    private static String numberFormatException = "[ERROR] 3~20 사이의 숫자만 입력이 가능합니다.";

    public static void main(String[] args) {
        // 프로그램 구현
        outputView.printStart();
        try {
            bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        } catch (NumberFormatException e) {
            System.out.println(numberFormatException);
            return;
        }
        bridgeController.validateMove(bridge);
        outputView.printResult();
    }
}
