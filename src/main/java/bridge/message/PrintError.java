package bridge.message;

public enum PrintError {

    SIZE_RANGE("[ERROR]: 다리의 길이는 3 이상 20 이하의 숫자만 입력해주세요."),
    SIZE_NUMBER("[ERROR]: 다리의 길이는 숫자만 입력해주세요."),
    MOVING("[ERROR]: 이동할 칸은 U나 D만 입력해주세요."),
    COMMAND("[ERROR]: R이나 Q만 입력해주세요.");

    private final String message;

    PrintError(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
