package data;

public enum ExceptionData {
    HEAD("[ERROR]"),
    EXCEPTION_SIZE(HEAD.exceptionMessage + " 다리 길이는 " + BridgeData.MINIMUM_LENGTH +
        "부터 "+  BridgeData.MAXIMUM_LENGTH + "사이의 숫자여야 합니다."),
    EXCEPTION_MOVE(HEAD.exceptionMessage +" 이동은 대문자 " + BridgeData.UP +
        ", 대문자 " + BridgeData.DOWN + "만 입력할 수 있습니다."),
    EXCEPTION_RESTART(HEAD.exceptionMessage + " 재시도는 대문자 R, 대문자 Q만 입력할 수 있습니다.");

    private final String exceptionMessage;

    ExceptionData(String exceptionMessage){
        this.exceptionMessage = exceptionMessage;
    }

    public void printExceptionData(){
        System.out.println(exceptionMessage);
    }
}
