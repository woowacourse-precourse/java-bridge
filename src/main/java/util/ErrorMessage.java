package util;

public class ErrorMessage {
    public static final String ERROR_PREFIX = "[ERROR] ";

    public static final String IS_NOT_DIGIT=ERROR_PREFIX+"입력은 자연수만 가능합니다.(ex - 3)\n";
    public static final String NOT_RANGE_BRIDGE_SIZE=ERROR_PREFIX+"다리의 길이는 3이상 20이하의 숫자만 가능합니다.(ex - 3)\n";

    public static final String SHOULD_CHARACTER = ERROR_PREFIX + "문자만을 입력하여주세요.";
}
