package view;

public enum ValidMessage {

    ValidLength("[ERROR] 다리 길이는 3~20 중 하나인 숫자입니다."),
    ValidMove("[ERROR] 입력시 U, D 중 하나를 입력해주세요."),
    ValidFinish("[ERROR] 입력시 Q, R 중 하나를 입력해주세요.");

    private final String message;

    private ValidMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
