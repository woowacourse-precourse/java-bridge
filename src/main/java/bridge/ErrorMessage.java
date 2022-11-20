package bridge;

public enum ErrorMessage {
    RIGHT_BRIDGE_RANGE("[ERROR] 3~20까지의 숫자를 입력해주세요");

    private String error_letter;

    private ErrorMessage(String error_letter) {
        this.error_letter = error_letter;
    }
}
