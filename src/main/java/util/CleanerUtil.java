package util;

import constant.BothSideConstant;
import java.util.List;

public class CleanerUtil {
    private static final int UP_SIDE_INDEX = BothSideConstant.UP_SIDE_INDEX.getConstant();
    private static final int DOWN_SIDE_INDEX = BothSideConstant.DOWN_SIDE_INDEX.getConstant();

    public static void clearBothSide(List<List<String>> bothSide) {
        bothSide.get(UP_SIDE_INDEX).clear();
        bothSide.get(DOWN_SIDE_INDEX).clear();
    }
}
