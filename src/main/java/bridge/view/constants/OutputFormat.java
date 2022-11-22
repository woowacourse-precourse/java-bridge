package bridge.view.constants;

/**
 * 출력 메시지에 사용되는 형식을 저장하는 상수 클래스
 */
public enum OutputFormat {

    RESULT_HAS_SUCCEED("게임 성공 여부: %s"),
    RESULT_TRIAL_COUNT("총 시도한 횟수: %d"),

    ERROR_MESSAGE("[ERROR] %s"),
    ERROR_USER_INPUT_MESSAGE("[ERROR] 사용자 입력 오류: %s"),
    ERROR_GAME_MESSAGE("[ERROR] 게임 기능 오류: %s");

    private final String value;

    OutputFormat(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
