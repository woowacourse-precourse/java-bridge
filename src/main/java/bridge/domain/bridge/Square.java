package bridge.domain.bridge;

import bridge.domain.move.MoveType;

import java.util.Objects;

public class Square {

    private static final String REG_XP_MOVE_TYPE = "[UD]+";
    private static final int MOVE_COUNT = 1;

    private final MoveType moveType;

    public Square(MoveType moveType) {
        this.moveType = moveType;
    }

    public static Square of(String moveType) {
        isValidMoveType(moveType);
        isValidMoveTypeCount(moveType);
        return new Square(MoveType.of(moveType));
    }

    private static void isValidMoveType(String moveType) {
        if (!moveType.matches(REG_XP_MOVE_TYPE)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 문자만 입력 가능합니다.");
        }
    }

    private static void isValidMoveTypeCount(String moveType) {
        if (moveType.length() != MOVE_COUNT) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 중에 하나만 입력 가능합니다.");
        }
    }

    public boolean isUp() {
        return Objects.equals(moveType, MoveType.UP);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Square)) {
            return false;
        }
        Square square = (Square) obj;
        return Objects.equals(square.moveType, moveType);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(moveType);
    }

    @Override
    public String toString() {
        return moveType.toString();
    }
}
