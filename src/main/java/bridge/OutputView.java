package bridge;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_PHRASES = "다리 건너기 게임을 시작합니다.";
    private static final String ASK_LENGTH_PHRASES = "다리의 길이를 입력해주세요.";
    private static final String ASK_MOVING_PHRASES = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    /**
     * 게임이 시작할 때의 문구를 출력한다.
     */
    public void printStartPhrases() {
        System.out.println(START_PHRASES);
        System.out.println();
    }

    /**
     * 다리 길이를 요구하는 문구를 출력한다.
     */
    public void printAskLengthPhrases() {
        System.out.println(ASK_LENGTH_PHRASES);
    }

    /**
     * 이동에 대한 입력을 요구하는 문구를 출력한다.
     */
    public void printAskMovingPhrases() {
        System.out.println(ASK_MOVING_PHRASES);
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
