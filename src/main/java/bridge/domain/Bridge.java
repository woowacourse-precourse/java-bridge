package bridge.domain;

import bridge.BridgeMaker;
import bridge.view.InputView;

import java.util.List;

public class Bridge {

    private final List<String> bridge;
    private final int size;

    public Bridge(BridgeMaker bridgeMaker) {
        this.size = InputView.readBridgeSize();
        this.bridge = bridgeMaker.makeBridge(size);
    }

    public boolean isCorrectCell(String command, int round) {
        return command.equals(bridge.get(round));
    }

    public boolean isArriveEnd(int round) {
        return round == size;
    }
}
