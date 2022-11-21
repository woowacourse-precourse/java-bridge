package bridge;

import bridge.model.Result;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;

public class Application {
    private static BridgeMaker bridgeMaker;
    private static InputView inputView;
    private static OutputView outputView;
    private static BridgeGame bridgeGame;
    private static Result result;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static void initialize() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        inputView = new InputView();
        outputView = new OutputView();
        result = new Result();
    }
}
