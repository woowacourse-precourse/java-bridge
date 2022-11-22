package bridge;

import java.util.List;

public class BridgeGameService {
    private static final InputView inputView = new InputView();
    private static final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(generator);

    public Integer askBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> makeBridge(Integer bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }



}
