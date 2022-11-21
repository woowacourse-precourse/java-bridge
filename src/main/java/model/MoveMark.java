package model;

import java.util.Objects;

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

    public String getMark() {
        return mark;
    }

    private void validateValue(String moving) {
        if (!UP.isEqualsMark(moving) && !DOWN.isEqualsMark(moving)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }

    public BridgeType getBridgeType() {
        return BridgeType.getByMark(mark);
    }

    public boolean canMove(MoveMark mark) {
        return this.equals(mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoveMark moveMark = (MoveMark) o;
        return mark.equals(moveMark.mark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mark);
    }

    @Override
    public String toString() {
        return mark;
    }
}
