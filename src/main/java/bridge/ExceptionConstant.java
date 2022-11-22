package bridge;

public enum ExceptionConstant {
    NOT_NATURAL_NUMBER("다리 길이는 자연수여야 합니다.");

    private final String message;

    ExceptionConstant(String message) {
        this.message = String.format("[ERROR] %s", message);
    }

    public String getMessage() {
        return message;
    }
}
