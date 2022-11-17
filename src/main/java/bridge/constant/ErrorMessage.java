package bridge.constant;

public enum ErrorMessage {

    NOTICE("[ERROR] "),
    SIZE_OF_BRIDGE(
            String.format("다리의 길이는 %d이상 %d이하로 입력하셔야 합니다.",
                    BridgeRule.MINIMUM_SIZE.getSize(),
                    BridgeRule.MAXIMUM_SIZE.getSize())
    ),
    POSITION_IN_FORM_OF_NUMBER("다리 생성 도중 오류가 발생했습니다."),
    NOT_NUMBER("숫자를 입력해주세요");

    private final String message;
    private final StringBuilder sb = new StringBuilder();

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return sb.append(NOTICE.message).append(this.message).toString();
    }
}
