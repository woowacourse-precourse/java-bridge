package bridge.constants;

public enum OutputConstants {
    START_MESSAGE("다리 건너기 게임을 시작합니다. \n"),

    SET_SIZE_BRIDGE_MESSAGE("다리의 길이를 입력해주세요"),

    CHOICE_UP_DOWN_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래 : D)"),

    RESULT_MESSAGE("최종 게임 결과"),

    SELECT_RESTART_OR_QUIT("게임을 다시 시도할지 여부를 입력해주세요. (재시도 : R, 종료 : Q)"),

    TOTAL_TRY("총 시도한 횟수: "),

    SUCCEES("게임 성공 여부: 성공\n"),

    Fail("게임 성공 여부: 실패\n"),

    START("["),

    END("]"),

    MIDDLE("|");

    private String message;

    OutputConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.println(this.message);
    }
}
