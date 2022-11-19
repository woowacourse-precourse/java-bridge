package bridge.model;

import static bridge.controller.InputController.setBridgeSize;

import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge() {
        this.bridge = setBridgeSize();
        System.out.println(bridge);
    }

    public boolean isUserSelectionCorrect(String correctOption, String userSelection) {
        return correctOption.equals(userSelection);
    }

    public int getBridgeSize() {
        return bridge.size();
    }

    public String currentBridge(int index) {
        return bridge.get(index);
    }


}
