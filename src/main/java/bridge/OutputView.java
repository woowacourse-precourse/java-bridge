package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: ";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: ";

    private final Bridge bridge;

    public OutputView(Bridge bridge) {
        this.bridge = bridge;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        System.out.println(bridge.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap();
        System.out.println(GAME_SUCCESS_MESSAGE + bridge.getGameResultString());
        System.out.println(TRY_COUNT_MESSAGE + bridge.getTryCount());
    }
}
