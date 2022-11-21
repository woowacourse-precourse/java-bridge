package bridge.constant;

public enum ErrorMessage {

    NOTICE("[ERROR] "),
    SIZE_OF_BRIDGE(
            String.format(NOTICE.message + "다리의 길이는 %d이상 %d이하로 입력하셔야 합니다.",
                    BridgeRule.MINIMUM_SIZE.getSize(),
                    BridgeRule.MAXIMUM_SIZE.getSize())
    ),
    POSITION_IN_FORM_OF_NUMBER(NOTICE.message + "다리 생성 도중 오류가 발생했습니다."),
    NOT_NUMBER(
            NOTICE.message +
            String.format(
                    "%d이상, %d이하의 \"정수\"만 입력하셔야 합니다.",
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE
            )
    ),
    MOVE_COMMAND(
            NOTICE.message +
                    "U(위 칸), D(아래 칸) 중 하나만 입력하셔야 합니다."
    );

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
