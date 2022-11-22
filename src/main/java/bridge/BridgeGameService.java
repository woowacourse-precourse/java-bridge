package bridge;

import java.util.List;

public class BridgeGameService {
    private static final InputView inputView = new InputView();
    private static final BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(generator);
    private static final BridgeGame bridgeGame = new BridgeGame();

    public Integer askBridgeSize() {
        while (true) {
            try {
                return inputView.readBridgeSize();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String askMoving() {
        while (true) {
            try {
                return inputView.readMoving();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> makeBridge(Integer bridgeSize) {
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public boolean isMovable(List<String> bridge, List<String> map) {
        if (bridgeGame.move(bridge, map) && bridge.size() != map.size()) {
            return true;
        }
        return false;
    }


}
