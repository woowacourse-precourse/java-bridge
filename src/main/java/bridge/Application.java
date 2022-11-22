package bridge;

import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGameRun bridgeGameRun = new BridgeGameRun(inputView, outputView);
        bridgeGameRun.gameStart();
    }
}
