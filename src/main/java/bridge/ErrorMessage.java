package bridge;

public enum ErrorMessage {
    RIGHT_BRIDGE_SIZE("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    RIGHT_BRIDGE_CHOICE("[ERROR] 적절한 이동 칸을 (위칸 U, 아래 칸 D) 입력해주세요."),
    RIGHT_COMMEND("[ERROR] 적절한 시도 여부(재시도: R, 종료: Q)를 입력해주세요.");

    private String error_letter;

    private ErrorMessage(String error_letter) {
        this.error_letter = error_letter;
    }

    public String getError_letter() {
        return error_letter;
    }
}
