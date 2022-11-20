package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {
    static OutputView outputView = new OutputView();
    static InputView inputView = new InputView();

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        outputView.printStart();

        int size = 0;
        while (size == 0) {
            try {
                outputView.printInputBridgeSize();
                size = inputView.readBridgeSize();
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        BridgeGame bridgeGame = new BridgeGame();

        List<String> bridge = bridgeMaker.makeBridge(size);
        List<String> userMoving = new ArrayList<>();

        while (bridgeGame.isProceeding()) {
            String moving = "";
            while (moving.equals("")) {
                try {
                    outputView.printInputMoving();
                    moving = inputView.readMoving();
                } catch (IllegalArgumentException exception) {
                    System.out.println(exception.getMessage());
                }
            }

            userMoving.add(moving);

            // 다리 결과 출력
            outputView.printMap(bridge, userMoving);

            // 다리 상태 변경
            bridgeGame.changeResult(bridge, userMoving);
        }
    }
}
