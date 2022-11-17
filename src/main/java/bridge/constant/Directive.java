package bridge.constant;

public enum Directive {

    INPUT_LENGTH_OF_BRIDGE("다리의 길이를 입력해주세요.");

    private final String message;

    Directive(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
