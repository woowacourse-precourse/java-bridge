package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private static final String UPPER_BRIDGE_STRING = "U";
    private static final String LOWER_BRIDGE_STRING = "D";
    private static final String CAN_GO_STRING = "O";
    private static final String CANNOT_GO_STRING = "X";
    private List<String> bridgeString;
    private List<String> upperBridge = new ArrayList<>();
    private List<String> lowerBridge = new ArrayList<>();

    public Bridge(List<String> bridgeString) {
        validBridgeString(bridgeString);
        this.bridgeString = bridgeString;
        makeBridge();
    }

    public void makeBridge() {
        for (int i = 0; i < bridgeString.size(); i++) {
            if (bridgeString.get(i).equals(UPPER_BRIDGE_STRING)) {
                upperBridge.add(CAN_GO_STRING);
                lowerBridge.add(CANNOT_GO_STRING);
            } else if (bridgeString.get(i).equals(LOWER_BRIDGE_STRING)) {
                upperBridge.add(CANNOT_GO_STRING);
                lowerBridge.add(CAN_GO_STRING);
            }
        }
    }

    public void validBridgeString(List<String> bridgeString) {
        for (String answerBridge : bridgeString) {
            if (!(answerBridge.equals(UPPER_BRIDGE_STRING) || answerBridge.equals(LOWER_BRIDGE_STRING))) {
                throw new IllegalArgumentException();
            }
        }
    }


    public List<String> getBridgeString() {

        return bridgeString;
    }

    public List<String> getUpperBridge() {

        return upperBridge;
    }

    public List<String> getLowerBridge() {

        return lowerBridge;
    }
}
