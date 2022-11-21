package enumCollections;

public enum ExceptionMessage {
    RESTART("R(재시작) 또는 Q(종료) 이외의 문자를 입력할 수 없습니다."),
    SELECT_SIDE("U(위) 또는 D(아래) 이외의 문자를 입력할 수 없습니다."),
    NOT_NUMERIC("숫자만 입력할 수 있습니다."),
    NOT_CHARACTER("문자만 입력할 수 있습니다."),
    SMALLER_THAN_MINIMUM_BRIDGE_LENGTH("3보다 작은 길이를 입력할 수 없습니다."),
    BIGGER_THAN_MAXIMUM_BRIDGE_LENGTH("20보다 큰 길이를 입력할 수 없습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] ".concat(message);
    }

    public static String getMessage(ExceptionMessage situation) {
        return situation.message;
    }
}
