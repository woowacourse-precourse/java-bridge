package bridge.domain.user;

public enum MoveType {
    UP_TYPE("U", 1),
    DOWN_TYPE("D", 0);

    private static final String UNSUPPORTED_TYPE_ERROR = "움직일 수 있는 타입은 'U' 또는 'D' 뿐입니다.";
    private final String type;
    private final int typeNumber;

    MoveType(String type, int typeNumber) {
        this.type = type;
        this.typeNumber = typeNumber;
    }

    /**
     * @param typeNumber
     * @return 무작위로 0 또는 1의 숫자를 받아서 Type String으로 변경해준다.
     */
    public static String convertType(int typeNumber) {
        if (typeNumber == UP_TYPE.typeNumber) {
            return UP_TYPE.type;
        }

        if (typeNumber == DOWN_TYPE.typeNumber) {
            return DOWN_TYPE.type;
        }

        throw new IllegalArgumentException(UNSUPPORTED_TYPE_ERROR);
    }

    public static MoveType convertMoveType(String inputType) {
        return java.util.Arrays.stream(MoveType.values())
            .filter(moveType -> moveType.compareTo(inputType))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(UNSUPPORTED_TYPE_ERROR));
    }

    public boolean compareTo(String moveType) {
        return moveType.equals(this.type);
    }
}
