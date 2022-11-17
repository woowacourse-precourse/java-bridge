package bridge;

public enum EnumStrings {
    PATTERN("^[0-9]*$"),
    PRINT_START("다리 건너기 게임을 시작합니다."),
    PRINT_SIZE ("다리의 길이를 입력해주세요."),
    PRINT_MOVE ("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    PRINT_RETRY ("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    SUCCESS("성공"),
    FAIL("실패");

    private String message;

    EnumStrings(String message) {
        this.message=message;
    }

    public String getValue() {
        return message;
    }
}
