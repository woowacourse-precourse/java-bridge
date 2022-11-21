package bridge.util;

/**
 * 에러 메세지를 관리하는 enum 클래스
 */
public enum Error {

    OUT_OF_RANGE("다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    NOT_U_NOR_D("입력은 U 또는 D 중 하나여야 합니다."),
    NOT_R_NOR_Q("입력은 R 또는 Q 중 하나여야 합니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "[ERROR] " + message;
    }
}
