package bridge.enummodel;

public enum MessageEnum {

    INPUT_BRIDGE_SIZE("다리의 길이를 입력해주세요."),
    SELECT_MOVE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    RETRY_COMMAND("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),
    GAME_END_INFO("최종 게임 결과"),
    GAME_RESULT("게임 성공 여부: "),
    GAME_TRY("총 시도한 횟수: "),
    GAME_START("다리 건너기 게임을 시작합니다.");



    private final String value;

    MessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
