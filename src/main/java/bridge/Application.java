package bridge;

import bridge.domain.BridgeGameService;
import bridge.domain.Input;
import bridge.domain.Output;
import bridge.infra.InputView;
import bridge.infra.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new InputView();
        Output output = new OutputView();
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker maker = new BridgeMaker(generator);
        BridgeGameService gameService = new BridgeGameService(input, maker, output);
        gameService.start();
    }
}
