package bridge;

public enum BridgeConstant {

    GAME_START("다리 건너기 게임을 시작합니다."),
    INPUT_BRIDGE_LENGTH("다리의 길이를 입력해주세요."),
    INPUT_TYPE_EXCEPTION("[ERROR] 숫자를 입력해주세요."),
    INPUT_BOUNDARY_EXCEPTION("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");

    private final String value;

    BridgeConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
