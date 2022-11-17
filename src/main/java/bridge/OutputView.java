package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String STARTING_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_FOR_GET_LENGTH = "다리의 길이를 입력해 주세요.";
    private static final String MESSAGE_FOR_GET_SPACE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void printInitialMessages() {
        System.out.println(STARTING_MESSAGE);
        System.out.println(MESSAGE_FOR_GET_LENGTH);
    }

    public void printMessageToGetSpaceToMove() {
        System.out.println(MESSAGE_FOR_GET_SPACE);
    }

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
}
