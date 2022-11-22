package bridge;

public enum ErrorMessage {

    NOT_ALLOWED_DATA_TYPE("[ERROR]" + " 허용 하지 않는 자료형이 포함되어있습니다. " +
            "다리의 길이는 다리의 길이는 3이상 20이하의 정수만 가능합니다.\n\n다리의 길이를 입력해주세요."),
    OUT_OF_RANGE("[ERROR]" + "입력 가능한 범위를 초과했습니다. " +
            "다리의 길이는 3이상 20이하의 정수만 가능합니다.\n\n다리의 길이를 입력해주세요."),
    NOT_ALLOWED_MOVING("[ERROR]" + "허용하지 않는 입력값 입니다. " +
            "이동은 U, D 중 하나의 문자로만 입력할 수 있습니다.\n\n이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    NOT_ALLOWED_GAME_COMMAND("[ERROR]" + "허용하지 않는 입력값 입니다. " +
            "게임 재시작 여부는 R, Q 중 하나의 문자만 입력할 수 있습니다." +
            "\n\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)")
    ;

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
