package bridge.domain;

import bridge.exception.BridgeException;

import java.util.List;

public class Bridge {
    private int bridgeLength;
    private List<String> resultBridge;

    public int getBridgeLength() {
        return bridgeLength;
    }

    public List<String> getResultBridge() {
        return resultBridge;
    }

    public void inputBridgeLength(String input){
        validate(input);
        bridgeLength = Integer.parseInt(input);
    }

    private void validate(String input){
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(BridgeException.NOT_DISIT.getErrorMessage());
        }

        int intInput = Integer.parseInt(input);

        if (intInput > 20 || intInput < 3)
            throw new IllegalArgumentException(BridgeException.INVALID_LENGTH_RANGE.getErrorMessage());
    }

}
