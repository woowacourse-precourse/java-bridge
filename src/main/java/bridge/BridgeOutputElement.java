package bridge;

import java.util.Arrays;

public enum BridgeOutputElement {
    UPPER("U", 1, ""),
    LOWER("D", 0, "");

    private String userMovingInput;
    private int bridgeRandomNumber;
    private String addBridge;

    BridgeOutputElement(String userMovingInput, int bridgeRandomNumber, String addBridge) {
        this.userMovingInput = userMovingInput;
        this.bridgeRandomNumber = bridgeRandomNumber;
        this.addBridge = addBridge;
    }

    public void addUserInput (String userMovingInput) {
        BridgeOutputElement userInputBridge = findByUserMovingInput(userMovingInput);
        Integer otherNumber = Integer.valueOf(1-findByUserMovingInput(userMovingInput).bridgeRandomNumber);
        BridgeOutputElement otherBridge = findByBridgeRandomNumber(otherNumber);
        userInputBridge.addBridge += userInputBridge.userMovingInput;
        otherBridge.addBridge += " ";
    }

    public String getAddBridge(BridgeOutputElement bridgeOutputElement) {
        return bridgeOutputElement.addBridge;
    }

    public BridgeOutputElement findByUserMovingInput (String userMovingInput) {
        return Arrays.stream(values())
                .filter(bridgeOutputElement -> bridgeOutputElement.userMovingInput.equals(userMovingInput))
                .findAny()
                .orElse(null);
    }

    public BridgeOutputElement findByBridgeRandomNumber (int bridgeRandomNumber) {
        return Arrays.stream(values())
                .filter(bridgeOutputElement -> Integer.valueOf(bridgeOutputElement.bridgeRandomNumber).equals(bridgeRandomNumber))
                .findAny()
                .orElse(null);
    }
}
