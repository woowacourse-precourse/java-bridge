package bridge.util;

public enum ExceptionPhrases {
    ERROR("[ERROR] "),
    IS_EMPTY_INPUT("빈 문자열을 입력하였습니다."),
    IS_NOT_NUMBER("숫자만으로 구성되어있지 않습니다."),
    IS_OUTOF_BRIDGE_SIZE("설정할 수 있는 다리의 길이 범위에 벗어납니다."),
    IS_NOT_MOVE_COMMAND("규격에 맞에 다시 입력해주세요.(위: U, 아래: D)"),
    IS_NOT_STATUS_COMMAND("규격에 맞에 다시 입력해주세요.(재시작: R, 종료: Q)");
    private final String pharases;

    ExceptionPhrases(String pharases) {
        this.pharases = pharases;
    }

    public String getPharases() {
        return ERROR.pharases + pharases;
    }
}
