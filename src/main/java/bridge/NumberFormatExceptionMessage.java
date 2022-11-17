package bridge;

public enum NumberFormatExceptionMessage {

    NUMBER_FORMAT_EXCEPTION_MESSAGE("[ERROR] 숫자만 입력해주세요.");

    private final String NumberFormatExceptionMessage;

    NumberFormatExceptionMessage(String numberFormatExceptionMessage) {
        this.NumberFormatExceptionMessage = numberFormatExceptionMessage;
    }

    public String getNumberFormatExceptionMessage() {
        return NumberFormatExceptionMessage;
    }
}
