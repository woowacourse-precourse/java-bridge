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

    public void resultBridge(List<String> answer, String userUpDown, int blankNumber) {
        String gather = resultBridgeCondition(answer, userUpDown, blankNumber);
        System.out.println("[ " + gather + " ]");
    }

    private String resultBridgeCondition(List<String> answer, String userUpDown, int blankNumber) {
        if (blankNumber == 0) {
            return blankStep(viewBlank(answer.get(blankNumber), userUpDown), blankNumber);
        }
        return gatherBlank(untilBlank(answer, blankNumber),
                blankStep(viewBlank(answer.get(blankNumber), userUpDown), blankNumber));
    }


    private String untilBlank(List<String> answer, int blankNumber) {
        String gather = "";
        for (int i = 0; i < blankNumber; i++) {
            String blanks = correctBlankCondition(answer.get(i), i);
            gather = gatherBlank(gather, blanks);
        }
        return gather;
    }

    private String correctBlankCondition(String answer, int i) {
        if (answer.equals(bridgeType)) {
            return blankStep(correctBridge, i);
        }
        return blankStep(emptyBridge, i);
    }

    private String gatherBlank(String untilBlank, String blankStep) {
        String gather = untilBlank + blankStep;
        return gather;
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
