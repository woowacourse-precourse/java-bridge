package bridge.model;

import java.util.ArrayList;
import java.util.List;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.utils.Validator;
import bridge.view.OutputView;

public class Bridge {
    private List<String> bridge;

    static BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public static List<String> makeBridge() {
        int bridgeSize = Validator.readBridgeSize();
        return bridgeMaker.makeBridge(bridgeSize);
    }

    public String crossablePosition(int round) {
        return bridge.get(round);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public void printMap(int round, boolean isCross) {
        List<String> usedMap = new ArrayList<>(bridge.subList(0, round + 1));
        OutputView.printMap(usedMap, isCross);
    }

    public List<String> getUsedMap(int round) {
        return bridge.subList(0, round);
    }

    public void printResult(int attemptCount, int round, boolean isCross) {
        List<String> usedMap = new ArrayList<>(getUsedMap(round));
        OutputView.printResult(usedMap, isCross, attemptCount);
    }
}
