package bridge;

public class ExceptionConst {
    public static String EXCEPTION_MESSAGE_ONLY_NUMBER = "[ERROR] 숫자만 입력해주세요.";
    public static String EXCEPTION_MESSAGE_U_OR_D = "[ERROR] U 또는 D만 허용됩니다.";
    public static String EXCEPTION_MESSAGE_R_OR_Q = "[ERROR] R 또는 Q만 허용됩니다.";
    public static String EXCEPTION_MESSAGE_LONG_STRING = "[ERROR] 너무 긴 문자열은 입력할 수 없습니다.";
    public static String EXCEPTION_MESSAGE_0_OR_1 = "[ERROR] 0 또는 1만 허용됩니다.";
    public static String EXCEPTION_MESSAGE_BRIDGE_LENGTH_OVER_USER = "[ERROR] 유저가 건넌 다리의 길이가 다리의 길이보다 깁니다.";
    public static String EXCEPTION_MESSAGE_BRIDGE_LENGTH_3_TO_20 = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    public static String EXCEPTION_MESSAGE_ILLEGAL_INDEX = "[ERROR] 인덱스가 음수거나 범위를 초과했습니다.";

    private ExceptionConst() {
    }
}
