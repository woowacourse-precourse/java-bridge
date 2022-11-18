package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static InputView input = new InputView();
    private static OutputView output = new OutputView();
    private static int bridgeSize;

    public static void main(String[] args) {
        try {
            // 게임 시작
            output.printStartMessage();
            output.printBridgeLengthInputRequestMessage();
            bridgeSize = input.readBridgeSize();

            System.out.println(bridgeSize);

            output.printMoveSpaceInputRequestMessage();
            input.readMoving();
        } catch (IllegalArgumentException e) {
            System.out.printf("[ERROR] %s", e.getMessage());
        }

        // TODO: 프로그램 구현
    }
}
