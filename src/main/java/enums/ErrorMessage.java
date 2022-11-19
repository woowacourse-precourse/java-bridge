package enums;

public enum ErrorMessage {
    INVALID_BRIDGE_SIZE("[ERROR] 유효한 다리 길이가 아닙니다. 유효 다리 길이는 3이상 20이하 입니다."),
    INVALID_MOVING_SPOT("[ERROR] 유효한 이동 칸이 아닙니다. 유효 이동 칸은 U 혹은 D 입니다."),
    INVALID_RETRIAL("[ERROR] 유효한 입력 값이 아닙니다. 재시도는 R을 종료는 Q를 입력해주세요.");

    private String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
