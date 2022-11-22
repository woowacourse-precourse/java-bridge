package util;

import constant.BothSideConstant;
import java.util.List;

public class CleanerUtil {

    public static void clearBothSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE_INDEX.getConstant()).clear();
        bothSide.get(BothSideConstant.DOWN_SIDE_INDEX.getConstant()).clear();
    }
}
