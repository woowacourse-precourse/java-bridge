package bridge.util;

import java.util.regex.Pattern;

public class Constants {
    private Constants() {
    }
    public static final Pattern BRIDGE_SIZE_REGEX = Pattern.compile("^[0-9]*$");
    public static final int MIN_BRIDGE_SIZE = 3;
    public static final int MAX_BRIDGE_SIZE = 20;
    public static final String BRIDGE_START = "[ ";
    public static final String BRIDGE_SEPARATER = " | ";
    public static final String BRIDGE_END = " ]";
    public static final String BRIDGE_WHITE_SPACE = " ";
    public static final int INITIAL_ATTEMPTS = 1;
    public static final String OUTPUT_FINAL_RESULT = "최종 게임 결과";
    public static final String OUTPUT_SUCCESS_OR_FAIL = "게임 성공 여부: ";
    public static final String OUTPUT_ATTEMPTS = "총 시도한 횟수: ";
    public static final String OUTPUT_START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String OUTPUT_ENTER_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String OUTPUT_ENGER_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String OUTPUT_ENTER_RETRY_OR_QUIT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";


}
