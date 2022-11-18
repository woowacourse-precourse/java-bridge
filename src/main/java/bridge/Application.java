package bridge;

import java.util.List;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.printStart();
        outputView.printEnterBridgeSize();
        try {
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

            do {
                BridgeGame bridgeGame = new BridgeGame();
                outputView.printEnterMove();
                String direction = inputView.readMoving();
                bridgeGame.move(direction);
                // direction 정오 판단
                // 현재까지의 결과 출력
            } while (false); // 탈출 조건: 다 맞거나, 현 단계 예측 틀릴때까지

        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
        }
    }
}
