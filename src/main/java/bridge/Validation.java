package bridge;

public class Validation {
    private static final int LENGTH_FLOOR = 3;
    private static final int LENGTH_CEILING = 20;
    private static final String LENGTH_OUT_OF_BOUNDS = "다리의 길이는 3 이상 20 이하여야 합니다.";
    private static final String NOT_U_OR_D = "U(위 칸)와 D(아래 칸) 중 하나의 문자만 선택하여 입력해야 합니다.";

    public static void validateLength(int length) throws IllegalArgumentException {
        if (length < LENGTH_FLOOR || length > LENGTH_CEILING) {
            throw new IllegalArgumentException(LENGTH_OUT_OF_BOUNDS);
        }
    }

    public static void validateSpace(String space) throws IllegalArgumentException {
        if (!space.equals("U") && !space.equals("D")) {
            throw new IllegalArgumentException(NOT_U_OR_D);
        }
    }

}
