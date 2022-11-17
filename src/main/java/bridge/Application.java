package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();

            // 다리 길이 입력받는 기능
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            int size = inputView.readBridgeSize();
            List<String> bridges = bridgeMaker.makeBridge(size);

            inputView.readMoving();
            inputView.readGameCommand();
            outputView.printGameStart();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
