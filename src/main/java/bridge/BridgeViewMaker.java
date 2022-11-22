package bridge;

import java.util.*;

public class BridgeViewMaker {
    String bridgeType;
    String correctBridge = "O";
    String incorrectBridge = "X";
    String emptyBridge = " ";
    String interval = " | ";

    public BridgeViewMaker(String bridgeType) {
        this.bridgeType = bridgeType;
    }


    private String blankStep(String content, int blankNumber) {
        if (blankNumber == 0) {
            return firstStep(content);
        }
        return steps(content);
    }

    private String firstStep(String content) {
        return content;
    }

    private String steps(String content) {
        return interval + content;
    }

    private String decideOX(String upDown, String userUpDown) {
        if (userUpDown.equals(upDown)) {
            return correctBridge;
        }
        return incorrectBridge;
    }

    private String viewBlank(String upDown, String userUpDown) {
        if (userUpDown.equals(bridgeType)) {
            return decideOX(upDown, userUpDown);
        }
        return emptyBridge;
    }
}
