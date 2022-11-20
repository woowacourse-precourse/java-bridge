package util;

import constant.NumberConstant;
import java.util.List;
import model.BridgeGame;

public class Cleaner {
    public static void clearBothSide(List<List<String>> bothSide) {
        bothSide.get(NumberConstant.UP_SIDE.getConstant()).clear();
        bothSide.get(NumberConstant.DOWN_SIDE.getConstant()).clear();
    }

    public static void clearTryNumber() {
        BridgeGame.tryNumber = NumberConstant.FIRST_TRY.getConstant();
    }
}
