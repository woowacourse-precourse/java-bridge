package bridge;

import bridge.domain.bridge.Bridge;
import bridge.domain.result.Map;
import bridge.domain.result.Result;
import bridge.service.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import bridge.view.ViewController;

public class Application {

    public static void main(String[] args) {
        ViewController viewController = new ViewController(new InputView(), new OutputView());

        Bridge bridge = new Bridge(new BridgeMaker(new BridgeRandomNumberGenerator()));
        Result result = new Result(new Map());

        BridgeGame bridgeGame = new BridgeGame(bridge, result);

        BridgeApp bridgeApp = new BridgeApp(viewController, bridgeGame);
        System.out.println("다리 건너기 게임을 시작합니다.");
        bridgeApp.run();
    }
}
