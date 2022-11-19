package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static OutputView outputView = new OutputView();
    static BridgeRandomNumberGenerator br = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(br);
    static InputView inputView = new InputView();
    static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridge = new ArrayList<>();
    private static String retryInput = "";
    private static String resultMessage = "최종 게임 결과";
    private static String numberFormatException = "[ERROR] 3~20 사이의 숫자만 입력이 가능합니다.";

    public static void main(String[] args) {
        // 프로그램 구현
        outputView.printStart();
        try {
            bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());
        } catch (NumberFormatException e) {
            System.out.println(numberFormatException);
        }
        validateMove();
        outputView.printResult();
    }

    public static void validateMove() {
        for (int i = 0; i < bridge.size(); i++) {
            if (bridgeGame.move(bridge.get(i), inputView.readMoving()).equals("X")) {
                outputView.printMap(bridge, BridgeGame.moveMapList);

            }
            if (retryInput.equals("Q")) return;
            if (i == bridge.size() - 1) System.out.println(resultMessage);
            if (i >= 0) outputView.printMap(bridge, BridgeGame.moveMapList);
        }
    }


}
