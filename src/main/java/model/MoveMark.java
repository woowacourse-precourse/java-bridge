package model;

import static constant.Config.ERROR;
import static model.BridgeType.DOWN;
import static model.BridgeType.UP;

public class MoveMark {
    private static final String VALUE_ERROR = ERROR + String.format("이동할 칸은 %s 또는 %s여야 합니다.", UP.getMark(), DOWN.getMark());
    private final String mark;

    public MoveMark(String mark) {
        String upperCaseMark = mark.toUpperCase().trim();

        validateValue(upperCaseMark);
        this.mark = upperCaseMark;
    }

    private void validateValue(String moving) {
        if (!UP.isEqualsMark(moving) && !DOWN.isEqualsMark(moving)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }
}
