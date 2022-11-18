package bridge;

public enum Exception {
    NotInteger("[ERROR]: 숫자를 입력해주세요."),
    NotInRange("[ERROR]: 3이상 20이하의 숫자를 입력해주세요.");
    private String message;
    Exception(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
