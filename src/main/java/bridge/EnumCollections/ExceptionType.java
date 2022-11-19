package bridge.EnumCollections;

public enum ExceptionType {
    BRIDGE_LENGTH_ERROR("입력하신 값이 3~20 사이의 숫자가 아닙니다."),
    BRIDGE_POSITION_ERROR("입력하신 값이 'U', 'D' 중 하나여야 합니다."),
    BRIDGE_RESTART_ERROR("재시작을 원하면 'R', 종료를 원하면 'Q'를 입력하세요");


    private String errorMessage;

    ExceptionType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + errorMessage;
    }
}
