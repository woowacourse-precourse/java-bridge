package bridge.util;

import static bridge.constant.InputKeyConstant.RETRY;
import static bridge.constant.InputKeyConstant.UP;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_BLANK;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.FIRST_TYPE_SUCCESS;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_BLANK;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_FAIL;
import static bridge.constant.BridgeMaterialConstant.SECOND_TYPE_SUCCESS;
import static bridge.constant.NumberConstant.FIRST_ROW;
import static bridge.constant.NumberConstant.SECOND_ROW;

import bridge.domain.CompareResult;
import java.util.List;

public final class Analyze {

    private Analyze() {
    }

    public static List<String> analyzePrintType(List<String> storedMap, CompareResult compareResult) {
        if (storedMap.get(FIRST_ROW.getCode()).isEmpty()) {
            oneDepthToAnalyze(storedMap, compareResult.getReadDirection(), compareResult.isCorrectDirection());
            return storedMap;
        }

        reverseOneDepthToAnalyze(storedMap, compareResult.getReadDirection(), compareResult.isCorrectDirection());

        return storedMap;
    }

    private static void reverseOneDepthToAnalyze(List<String> storedMap, String readDirection, boolean correctDirection) {
        if (correctDirection) {
            twoDepthToAnalyzeSecondType(storedMap, readDirection);
            return;
        }

        reverseTwoDepthToAnalyzeSecondType(storedMap, readDirection);
    }

    private static void twoDepthToAnalyzeSecondType(List<String> storedMap, String readDirection) {
        upTypeSecond(storedMap, readDirection, SECOND_TYPE_SUCCESS.getBridgeMaterial());
    }

    private static void reverseTwoDepthToAnalyzeSecondType(List<String> storedMap, String readDirection) {
        upTypeSecond(storedMap, readDirection, SECOND_TYPE_FAIL.getBridgeMaterial());
    }

    private static void upTypeSecond(List<String> storedMap, String readDirection, String bridgeMaterial) {
        if (readDirection.equals(UP.getFirstLetter())) {
            storedMap.set(FIRST_ROW.getCode(), storedMap.get(FIRST_ROW.getCode()) + bridgeMaterial);
            storedMap.set(SECOND_ROW.getCode(),
                    storedMap.get(SECOND_ROW.getCode()) + SECOND_TYPE_BLANK.getBridgeMaterial());
            return;
        }

        storedMap.set(FIRST_ROW.getCode(),
                storedMap.get(FIRST_ROW.getCode()) + SECOND_TYPE_BLANK.getBridgeMaterial());
        storedMap.set(SECOND_ROW.getCode(), storedMap.get(SECOND_ROW.getCode()) + bridgeMaterial);
    }

    private static void oneDepthToAnalyze(List<String> storedMap, String readDirection, boolean correctDirection) {
        if (correctDirection) {
            twoDepthToAnalyzeFirstType(storedMap, readDirection);
            return;
        }

        reverseTwoDepthToAnalyzeFirstType(storedMap, readDirection);
    }

    private static void twoDepthToAnalyzeFirstType(List<String> storedMap, String readDirection) {
        upTypeFirst(storedMap, readDirection, FIRST_TYPE_SUCCESS.getBridgeMaterial());
    }

    private static void reverseTwoDepthToAnalyzeFirstType(List<String> storedMap, String readDirection) {
        upTypeFirst(storedMap, readDirection, FIRST_TYPE_FAIL.getBridgeMaterial());
    }

    private static void upTypeFirst(List<String> storedMap, String readDirection, String bridgeMaterial) {
        if (readDirection.equals(UP.getFirstLetter())) {
            storedMap.set(FIRST_ROW.getCode(), storedMap.get(FIRST_ROW.getCode()) + bridgeMaterial);
            storedMap.set(SECOND_ROW.getCode(),
                    storedMap.get(SECOND_ROW.getCode()) + FIRST_TYPE_BLANK.getBridgeMaterial());

            return;
        }

        storedMap.set(FIRST_ROW.getCode(), storedMap.get(FIRST_ROW.getCode()) + FIRST_TYPE_BLANK.getBridgeMaterial());
        storedMap.set(SECOND_ROW.getCode(), storedMap.get(SECOND_ROW.getCode()) + bridgeMaterial);
    }

    public static boolean analyzeIsRetry(String gameCommand) {
        return gameCommand.equals(RETRY.getFirstLetter());
    }

}
