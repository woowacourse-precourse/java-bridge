package bridge.domain;

public class Square {

    private static final String REG_XP_MOVE_TYPE = "[UD]+";
    private static final int MOVE_COUNT = 1;

    private final int position;

    private final String moveType;

    public Square(int position, String moveType) {
        isValidMoveType(moveType);
        isValidMoveTypeCount(moveType);
        this.position = position;
        this.moveType = moveType;
    }

    private void isValidMoveType(String moveType) {
        if (!moveType.matches(REG_XP_MOVE_TYPE)) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 문자만 입력 가능합니다.");
        }
    }

    private void isValidMoveTypeCount(String moveType) {
        if (moveType.length() != MOVE_COUNT) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 중에 하나만 입력 가능합니다.");
        }
    }
}
