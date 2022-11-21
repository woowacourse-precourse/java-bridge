package model;

import constant.BothSideConstant;
import constant.PrintConstant;
import java.util.List;

public class BothSide {

    public static void addCorrectPathUpSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE_INDEX.getConstant()).add(PrintConstant.CORRECT_PATH.getConstant());
        bothSide.get(BothSideConstant.DOWN_SIDE_INDEX.getConstant()).add(PrintConstant.BLANK.getConstant());
    }

    public static void addCorrectPathDownSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE_INDEX.getConstant()).add(PrintConstant.BLANK.getConstant());
        bothSide.get(BothSideConstant.DOWN_SIDE_INDEX.getConstant()).add(PrintConstant.CORRECT_PATH.getConstant());
    }

    public static void addWrongPathUpSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE_INDEX.getConstant()).add(PrintConstant.WRONG_PATH.getConstant());
        bothSide.get(BothSideConstant.DOWN_SIDE_INDEX.getConstant()).add(PrintConstant.BLANK.getConstant());
    }

    public static void addWrongPathDownSide(List<List<String>> bothSide) {
        bothSide.get(BothSideConstant.UP_SIDE_INDEX.getConstant()).add(PrintConstant.BLANK.getConstant());
        bothSide.get(BothSideConstant.DOWN_SIDE_INDEX.getConstant()).add(PrintConstant.WRONG_PATH.getConstant());
    }
}
