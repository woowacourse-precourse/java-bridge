package bridge.Domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;



public class Bridge {
    private final static int MIN_BRIDGE_SIZE = 3;
    private final static int MAX_BRIDGE_SIZE = 50;
    private final static String WRONG_RANGE_INPUT = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";


    private List<String> bridgeStates;


    public Bridge(int bridgeSize) throws IllegalArgumentException {
        try {
            validate(bridgeSize);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }

        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        this.bridgeStates = bridgeMaker.makeBridge(bridgeSize);
    }


    public void validate(int bridgeSize) throws IllegalArgumentException {
        if (bridgeSize < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < bridgeSize) {
            throw new IllegalArgumentException(WRONG_RANGE_INPUT);
        }
    }

    public List<String> getBridgeStates() {
        return this.bridgeStates;
    }

    public String getBridgeState(int bridgeLocation) {
        return bridgeStates.get(bridgeLocation);
    }

}
