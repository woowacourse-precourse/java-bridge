package bridge.domain.stringenum;

public enum PrintMessage {
    START("다리 건너기 게임을 시작합니다."),
    BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    MOVE("이동할 칸을 선택해주세요."),
    RESTART("게임을 다시 시도할지 여부를 입력해주세요."),
    SUCCESS("게임 성공 여부: "),
    TRY("총 시도한 횟수: ");

    private final String value;

    PrintMessage(String value) {
        this.value = value;
    }

    public String printMessage() {
        return this.value;
    }
}
