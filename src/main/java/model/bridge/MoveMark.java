package model.bridge;

import java.util.Objects;

import static constant.Config.ERROR;
import static model.bridge.BridgeType.D;
import static model.bridge.BridgeType.U;

public class MoveMark {
    private static final String VALUE_ERROR = ERROR + String.format("이동할 칸은 %s 또는 %s여야 합니다.", U, D);
    private final BridgeType mark;

    public MoveMark(String mark) {
        String upperCaseMark = mark.toUpperCase().trim();

        validateValue(upperCaseMark);
        this.mark = BridgeType.valueOf(upperCaseMark);
    }

    public BridgeType getMark() {
        return mark;
    }

    private void validateValue(String moving) {
        if (!U.isEqualsMark(moving) && !D.isEqualsMark(moving)) {
            throw new IllegalArgumentException(VALUE_ERROR);
        }
    }

    public boolean canMove(BridgeType mark) {
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
