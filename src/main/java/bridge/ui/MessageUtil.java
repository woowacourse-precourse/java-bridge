package bridge.ui;

public enum MessageUtil {
    // 출력 관련
    START_GAME_INTRO("다리 건너기 게임을 시작합니다."),
    BRIDGE_SIZE_INPUT_INTRO("다리의 길이를 입력해주세요."),
    POSITION_CHOICE_INPUT("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    CONTINUE_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    FINAL_RESULT_INTRO("최종 게임 결과"),

    // 에러 관련
    EMPTY_INPUT("입력된 값이 없습니다. 확인해주세요."),
    INVALID_BRIDGE_SIZE("잘못된 입력 형식입니다. 3 ~ 20 사이의 숫자를 입력해주세요."),
    INVALID_MOVE_CHOICE("잘못된 입력 형식입니다. U, D 중 선택해주세요"),
    INVALID_GAME_CMD("잘못된 입력 형식입니다. R, Q 중 선택해주세요");

    public final String message;

    MessageUtil(String message) {
        this.message = message;
    }
}
