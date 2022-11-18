package data;

public enum ExceptionData {
    EXCEPTION_HEAD("[ERROR]"),
    EXCEPTION_SIZE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    EXCEPTION_MOVE("이동은 대문자 U, 대문자 D만 입력할 수 있습니다."),
    EXCEPTION_RESTART("재시도는 대문자 R, 대문자 Q만 입력할 수 있습니다.");

    private final String exceptionMessage;

    ExceptionData(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }
}
