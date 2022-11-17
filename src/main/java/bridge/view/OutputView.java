package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    static final String ERROR_HEADER = "[ERROR] ";

    public void printGameStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.\n");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(ERROR_HEADER + errorMessage);
    }

    public void printMap() {
    }

    public void printResult() {
    }
}
