package util.validator;

import constant.BothSideConstant;
import constant.InputConstant;
import constant.PrintConstant;
import java.util.List;

public class BridgeGameValidator {

    public static boolean isMoveDone(List<String> bridge, List<List<String>> bothSide) {
        return BridgeGameValidator.isUserInputDone(bridge, bothSide)
                || BridgeGameValidator.isContainWrongPath(bothSide);
    }

    private static boolean isUserInputDone(List<String> bridge, List<List<String>> bothSide) {
        return bridge.size() == bothSide.get(BothSideConstant.UP_SIDE.getConstant()).size();
    }

    public static boolean isBridgeEqualsD(String bridgeIndex) {
        return bridgeIndex.equals(InputConstant.DOWN_SIDE.getConstant());
    }

    public static boolean isBridgeEqualsU(String bridgeIndex) {
        return bridgeIndex.equals(InputConstant.UP_SIDE.getConstant());
    }

    public static boolean isContainWrongPath(List<List<String>> bothSide) {
        return bothSide.get(BothSideConstant.UP_SIDE.getConstant())
                .contains(PrintConstant.WRONG_PATH.getConstant())
                || bothSide.get(BothSideConstant.DOWN_SIDE.getConstant())
                .contains(PrintConstant.WRONG_PATH.getConstant());
    }

    public static boolean isUserInputRetry(String retryOrQuit) {
        return retryOrQuit.equals(InputConstant.RETRY.getConstant());
    }
}
