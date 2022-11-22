package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String LENGTH_INPUT_REQUEST_MESSAGE = "다리의 길이를 입력해주세요.";
    private static final String SELECT_PANEL_REQUEST_MESSAGE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String RESTART_QUESTION_MESSAGE = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final String IS_SUCCESS = "게임 성공 여부: ";
    private static final String NUMBER_OF_TRY = "총 시도한 횟수: ";
    private static final Character PANEL_SEPARATOR = '|';
    private static final Character BRIDGE_START_EDGE = '[';
    private static final Character BRIDGE_END_EDGE = ']';
    private static final Character CORRECT = 'O';
    private static final Character WRONG = 'X';
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Bridge bridge) {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printInputRequestMessage(){
        System.out.println(LENGTH_INPUT_REQUEST_MESSAGE);
    }

    public void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }
}
