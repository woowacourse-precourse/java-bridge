package bridge.exception;

public enum ERROR {
    sizeException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");


    private String exception;

    ERROR(String exception) {
        this.exception=exception;
    }

    public String getException() {
        return exception;
    }
}
