package bridge.domain;

public enum ValidationString {
    OVER_OR_UNDER_NUMBER_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NO_MATCH_BLANK_TO_MOVE("위로 이동하려면 U, 아래로 이동하려면 D를 입력해주세요."),
    NO_MATCH_RETRY_OR_END("재시도하려면 R, 종료하려면 Q를 입력해주세요.");

    private static final String error = "[ERROR] ";
    private final String content;

    ValidationString(String content){
        this.content = content;
    }

    public String getMessage(){
        return error+content;
    }

}
