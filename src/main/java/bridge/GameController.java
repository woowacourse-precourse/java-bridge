package bridge;

import java.util.List;

public class GameController {
    private final InputView input = new InputView();
    private final OutputView output = new OutputView();
    private final BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void start() {
        output.printStart();
        List<String> randomBridge = makeBridge();
        output.printMove();
        String move = input.readMoving();
    }

    private List<String> makeBridge() {
        output.printInputBridgeSize();
        int bridgeSize;
        while (true) {
            try {
                bridgeSize = input.readBridgeSize();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR]" + e.getMessage());
            }
        }
        return maker.makeBridge(bridgeSize);
    }
}
