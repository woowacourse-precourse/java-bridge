package bridge.util;

public class Constants {
    public static final int MINIMUM_BRIDGE_SIZE = 3;
    public static final int MAXIMUM_BRIDGE_SIZE = 20;

    public static final String ERROR_TITLE = "[ERROR] ";
    public static final String NON_ALPHABETIC_CHARACTER_FOUND = "알파벳 외의 값이 입력되었습니다.";
    public static final String EMPTY_INPUT = "입력된 값이 없습니다.";
    public static final String NON_DIGIT_CHARACTER_FOUND = "숫자 외의 값이 입력되었습니다.";

    public static final String MOVING_FORMAT = String.format(
            "다음 칸으로 이동하기 위해선 %s 또는 %s를 입력해야 합니다.",
            CommandKeys.UP.getLetter(),
            CommandKeys.DOWN.getLetter()
    );
    public static final String COMMAND_FORMAT = String.format(
            "게임 재개 여부를 정하기 위해선 %s 또는 %s를 입력해야 합니다.",
            CommandKeys.RETRY.getLetter(),
            CommandKeys.QUIT.getLetter()
    );
    public static final String BRIDGE_SIZE_FORMAT = String.format(
            "다리 길이는 %d부터 %d 사이의 숫자여야 합니다.",
            MINIMUM_BRIDGE_SIZE,
            MAXIMUM_BRIDGE_SIZE
    );
}
