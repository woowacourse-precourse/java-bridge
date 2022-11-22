package util;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String SHOULD_DIGIT =ERROR_PREFIX+"입력은 숫자만 가능합니다.(ex - 3)\n";
    public static final String NOT_RANGE_BRIDGE_SIZE=ERROR_PREFIX+"다리의 길이는 3이상 20이하의 숫자만 가능합니다.(ex - 3)\n";

    public static final String SHOULD_CHARACTER = ERROR_PREFIX + "문자만을 입력하여주세요.\n";

    public static final String STAIRS_U_OR_D = ERROR_PREFIX + "입력은 U 혹은 D 만 가능합니다.(위: U, 아래: D)\n";

    public static final String COMMAND_R_OR_Q = ERROR_PREFIX + "입력은 R 혹은 Q 만 가능합니다.(재시도: R, 아래: Q)\n";
}
