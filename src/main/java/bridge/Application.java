package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();

        outputView.startGame();
        int bridgeSize = inputView.readBridgeSize();
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
}
