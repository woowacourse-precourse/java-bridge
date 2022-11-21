package bridge;

import bridge.domain.BridgeGame;

import java.util.List;

public class Controller {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public List<String> make() {
        while (true) {
            try {
                int bridgeSize = inputView.readBridgeSize();
                BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
                return bridgeMaker.makeBridge(bridgeSize);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}