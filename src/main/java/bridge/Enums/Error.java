package bridge.Enums;

public enum Error {
    NOT_NUMERIC_ERROR           ("숫자만 입력 가능합니다."),
    BRIDGE_LEN_ERROR            ("다리 길이는 3부터 20사이의 숫자여야 합니다."),
    MOVE_ERROR                  ("이동 경로는 'U' 혹은 'D'이어야 합니다"),
    COMMAND_ERROR               ("커맨드는 'R' 혹은 'Q'이어야 합니다.");


    private static final String ERROR_MESSAGE = "[ERROR]";
    private String errorMessage;

    Error(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public void error(){
        System.out.println(ERROR_MESSAGE + this.errorMessage);
        throw new IllegalArgumentException(ERROR_MESSAGE + this.errorMessage);
    }
}
