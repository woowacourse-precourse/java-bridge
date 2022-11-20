package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static InputView input = new InputView();
    private static OutputView output = new OutputView();
    private static BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    private static BridgeGame game = new BridgeGame();
    private static List<String> bridge = new ArrayList<>();


    public static void main(String[] args) {
        try {
            // 게임 시작
            output.printStartMessage();
            output.printBridgeLengthInputRequestMessage();
            int bridgeSize = input.readBridgeSize();
            bridge = maker.makeBridge(bridgeSize); // 다리 만들기
//            System.out.println(bridge.toString());

            System.out.println(bridgeSize);

            output.printMoveSpaceInputRequestMessage();
            input.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }

        // TODO: 프로그램 구현
    }
}
