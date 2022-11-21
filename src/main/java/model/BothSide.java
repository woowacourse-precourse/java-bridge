package model;

import constant.BothSideConstant;
import constant.PrintConstant;
import java.util.List;

public class BothSide {
    private static final int UP_SIDE_INDEX = BothSideConstant.UP_SIDE_INDEX.getConstant();
    private static final int DOWN_SIDE_INDEX = BothSideConstant.DOWN_SIDE_INDEX.getConstant();
    private static final String CORRECT_PATH = PrintConstant.CORRECT_PATH.getConstant();
    private static final String WRONG_PATH = PrintConstant.WRONG_PATH.getConstant();
    private static final String BLANK = PrintConstant.BLANK.getConstant();

    public static void addWrongPathDownSide(List<List<String>> bothSide) {
        bothSide.get(UP_SIDE_INDEX).add(BLANK);
        bothSide.get(DOWN_SIDE_INDEX).add(WRONG_PATH);
    }

    public static void addWrongPathUpSide(List<List<String>> bothSide) {
        bothSide.get(UP_SIDE_INDEX).add(WRONG_PATH);
        bothSide.get(DOWN_SIDE_INDEX).add(BLANK);
    }

    public static void addCorrectPathDownSide(List<List<String>> bothSide) {
        bothSide.get(UP_SIDE_INDEX).add(BLANK);
        bothSide.get(DOWN_SIDE_INDEX).add(CORRECT_PATH);
    }

    public static void addCorrectPathUpSide(List<List<String>> bothSide) {
        bothSide.get(UP_SIDE_INDEX).add(CORRECT_PATH);
        bothSide.get(DOWN_SIDE_INDEX).add(BLANK);
    }
}
