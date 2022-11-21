package util.validator;

import constant.BothSideConstant;
import constant.InputConstant;
import constant.PrintConstant;
import java.util.List;

public class BridgeGameValidator {
    private static final int UP_SIDE_INDEX = BothSideConstant.UP_SIDE_INDEX.getConstant();
    private static final int DOWN_SIDE_INDEX = BothSideConstant.DOWN_SIDE_INDEX.getConstant();
    private static final String UP_SIDE = InputConstant.UP_SIDE.getConstant();
    private static final String DOWN_SIDE = InputConstant.DOWN_SIDE.getConstant();
    private static final String RETRY = InputConstant.RETRY.getConstant();
    private static final String WRONG_PATH = PrintConstant.WRONG_PATH.getConstant();

    public static boolean isMoveDone(List<String> bridge, List<List<String>> bothSide) {
        return BridgeGameValidator.isUserInputDone(bridge, bothSide)
                || BridgeGameValidator.isContainsWrongPath(bothSide);
    }

    private static boolean isUserInputDone(List<String> bridge, List<List<String>> bothSide) {
        return bridge.size() == bothSide.get(UP_SIDE_INDEX).size();
    }

    public static boolean isBridgeEqualsD(String bridgeIndex) {
        return bridgeIndex.equals(DOWN_SIDE);
    }

    public static boolean isBridgeEqualsU(String bridgeIndex) {
        return bridgeIndex.equals(UP_SIDE);
    }

    public static boolean isContainsWrongPath(List<List<String>> bothSide) {
        return bothSide.get(UP_SIDE_INDEX).contains(WRONG_PATH) || bothSide.get(DOWN_SIDE_INDEX).contains(WRONG_PATH);
    }

    public static boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(RETRY);
    }
}
