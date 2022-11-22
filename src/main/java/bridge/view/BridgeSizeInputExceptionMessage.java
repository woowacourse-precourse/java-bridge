package bridge.view;

public enum BridgeSizeInputExceptionMessage {

    NUMBER_FORMAT_EXCEPTION_MESSAGE("[ERROR] 숫자만 입력해주세요."),
    NUMBER_RANGE_EXCEPTION_MESSAGE("[ERROR] 3~20사이 숫자만 입력해주세요");

    private String bridgeSizeInputExceptionMessage;

    BridgeSizeInputExceptionMessage(String bridgeSizeInputExceptionMessage) {
        this.bridgeSizeInputExceptionMessage = bridgeSizeInputExceptionMessage;
    }

    public String getBridgeSizeInputExceptionMessage() {
        return bridgeSizeInputExceptionMessage;
    }

}
