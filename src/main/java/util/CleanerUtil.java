package util;

import constant.BothSideConstant;
import constant.NumberConstant;
import java.util.List;
import model.BridgeGame;

public class CleanerUtil {
    public static void clearBothSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE.getBothSideConstant()).clear();
        bothSide.get(BothSideConstant.DOWN_SIDE.getBothSideConstant()).clear();
    }

    public static void clearTryNumber() {
        BridgeGame.tryNumber = NumberConstant.FIRST_TRY.getConstant();
    }
}
