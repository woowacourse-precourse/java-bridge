package bridge.domain.stringenum;

public enum PrintMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요."),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요."),
    RESULT("게임 성공 여부: %s"),
    TRY("총 시도한 횟수: %d"),
    END("최종 게임 결과"),
    SUCCESS("성공"),
    FAIL("실패");

    private final String value;

    PrintMessage(String value) {
        this.value = value;
    }

    public String printMessage() {
        return this.value;
    }

    public String printMessage(boolean isSuccess) {
        if (isSuccess) {
            return String.format(value, SUCCESS.value);
        }
        return String.format(value, FAIL.value);
    }
}
