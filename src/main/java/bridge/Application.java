package bridge;

import java.util.concurrent.BrokenBarrierException;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        BridgeGameService bridgeGameService = new BridgeGameService(outputView, inputView);
        try {
            bridgeGameService.run();
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
        }
    }
}
