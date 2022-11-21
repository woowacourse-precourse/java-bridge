package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GAME_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_GAME_MESSAGE = "최종 게임 결과";
    private static final String GAME_RESULT_MESSAGE = "게임 성공 여부: ";
    private static final String GAME_REPEAT_MESSAGE = "총 시도한 횟수: ";
    public static final String GAME_ICON_OPEN = "[ ";
    public static final String GAME_ICON_CLOSE = " ]";
    public static final String GAME_ICON_BAR = " | ";
    public static final String GAME_ICON_O = "O";
    public static final String GAME_ICON_X = "X";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printStart() {
        System.out.println(START_GAME_MESSAGE);
    }
}
