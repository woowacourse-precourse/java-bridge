package bridge;

/**
 * 게임의 현재 상태를 출력하는 역할을 한다
 */
public class StateView {

    public void printInitialization() {
        System.out.println(StateMessage.INITIALIZATION.get());
    }
}

enum StateMessage {

    INITIALIZATION("다리 건너기 게임을 시작합니다.\n"),
    ERROR("[ERROR]"),
    ERROR_BRIDGE_SIZE(" 다리 길이는 3부터 20 사이의 숫자여야 합니다."),
    ERROR_NOT_MOVING_COMMAND(" 이동할 칸은 위 (U) 혹은 아래 (D)를 선택헤 주세요."),
    ERROR_LOWER_MOVING_COMMAND(" 이동할 칸은 위 (U) 혹은 아래 (D)를 대문자로 주세요."),
    ERROR_NOT_RETRY_COMMAND(" 재시도 (R) 혹은 종료 (Q)를 선택해 주세요."),
    ERROR_LOWER_RETRY_COMMAND(" 재시도 (R) 혹은 종료 (Q)를 선택해 주세요.");

    private final String message;

    StateMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}