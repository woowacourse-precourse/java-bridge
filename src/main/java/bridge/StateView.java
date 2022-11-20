package bridge;

/**
 * 게임의 현재 상태를 출력하는 역할을 한다
 */
public class StateView {

    public void printInitialization() {
        System.out.println(stateMessage.INITIALIZATION.get());
    }
}

enum stateMessage {

    INITIALIZATION("다리 건너기 게임을 시작합니다.\n");

    private final String message;

    stateMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}