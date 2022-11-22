package bridge.Model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;



public class Bridge {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 20;
    private final static String WRONG_RANGE_INPUT = "[ERROR] 다리 길이는 %d부터 %d 사이의 숫자여야 합니다." + System.lineSeparator();


    private final List<String> bridgeStates;


    public Bridge(int bridgeSize) throws IllegalArgumentException {
        try {
            validate(bridgeSize);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }

        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        bridgeStates = bridgeMaker.makeBridge(bridgeSize);
    }


    public void validate(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize) {
            String rangeError = String.format(WRONG_RANGE_INPUT, MIN_BRIDGE_SIZE, MAX_BRIDGE_SIZE);

            throw new IllegalArgumentException(rangeError);
        }
    }

    public List<String> getBridgeStates() {
        return bridgeStates;
    }

    public String getBridgeState(int bridgeLocation) {
        return bridgeStates.get(bridgeLocation);
    }
}
