package model.bridge;

import java.util.Objects;

import static model.bridge.PositionType.D;
import static model.bridge.PositionType.U;

public class MoveMark {

    private static final String VALUE_ERROR = String.format("이동할 칸은 %s 또는 %s여야 합니다.", U, D);
    private final PositionType mark;

    public MoveMark(String mark) {
        String upperCaseMark = mark.toUpperCase().trim();

        validateValue(upperCaseMark);
        this.mark = PositionType.valueOf(upperCaseMark);
    }

    public PositionType getMark() {
        return mark;
    }

    private void validateValue(String moving) {
        if (!U.isEqualsMark(moving) && !D.isEqualsMark(moving)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }

    public boolean canMove(PositionType mark) {
        return this.mark.equals(mark);
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
        return mark.toString();
    }
}
