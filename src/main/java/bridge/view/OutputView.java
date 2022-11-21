package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String RETRY_COUNT_FORMAT = "총 시도한 횟수: %d%n";

    public static final String OVER_MESSAGE = "최종 게임 결과";

    public void printStart() {
        System.out.println(START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String result) {
        System.out.println(result);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String message, int retryCount) {
        System.out.println(message);
        System.out.printf(RETRY_COUNT_FORMAT, retryCount);
    }

    public void printGameOverMessage() {
        System.out.println(OVER_MESSAGE);
    }
}
