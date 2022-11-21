package bridge.view;

import bridge.Constants;
import bridge.domain.Bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final Bridge bridge;
    private StringBuffer upperBuffer;
    private StringBuffer lowerBuffer;
    private List<String> choices;

    public OutputView(Bridge bridge) {
        this.bridge = bridge;
        upperBuffer = new StringBuffer();
        lowerBuffer = new StringBuffer();
    }

    public static void InitialMessage() {
        System.out.println(Constants.GameProcessMessages.INITIAL_MESSAGE);
    }

    private String properOXSpace(String UpOrDown , String directionChoice, String whereToPrint) {
        /* 실제로는 위냐 아래냐, 유저 선택은 뭐냐, 위쪽용 프린터냐 아래쪽용 프린터냐 */
        /* String UpOrDown = bridge.returnCertainIndexUpOrDown(index); */
        if (!(directionChoice.equals(whereToPrint))) {
            return Constants.GameElements.EMPTY;
        }
        if (UpOrDown.equals(directionChoice)) {
            return Constants.GameElements.CHOICE_EQUALS_DIRECTION;
        }
        return Constants.GameElements.CHOICE_UNEQUALS_DIRECTION;
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final int ongoing, List<String> choices) {
        clearBuffer();
        this.choices = choices;

        fillEachBuffer(upperBuffer, ongoing, Constants.UserChoices.UP_UPPERSTRING);
        System.out.println(upperBuffer);

        fillEachBuffer(lowerBuffer, ongoing, Constants.UserChoices.DOWN_UPPERSTRING);
        System.out.println(lowerBuffer);
    }

    private void fillEachBuffer(StringBuffer buffer, int ongoing, String whereToPrint) {
        buffer.append("[ ");
        for (int i = 0; i<=ongoing; i++) {
            String realUpOrDown = bridge.returnCertainIndexUpOrDown(i);
            buffer.append(properOXSpace(realUpOrDown, choices.get(i), whereToPrint));
            if (i != ongoing) {
                buffer.append(" | ");
            }
        }
        buffer.append(" ]");
    }

    private void clearBuffer() {
        upperBuffer.delete(0,upperBuffer.length());
        lowerBuffer.delete(0,lowerBuffer.length());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean pass, int tryNumber) {
        System.out.println(Constants.GameProcessMessages.FINAL_RESULT);
        System.out.println(upperBuffer.toString());
        System.out.println(lowerBuffer.toString());
        System.out.printf(Constants.GameProcessMessages.GAME_PASS_OR_NOT, printWinorLose(pass));
        printTryNumbers(tryNumber);
    }

    public String printWinorLose(boolean pass) {
        if (pass) {
            return Constants.GameProcessMessages.SUCCESS;
        }
        return Constants.GameProcessMessages.FAIL;
    }

    public void printTryNumbers(int tryNumber) {
        System.out.printf(Constants.GameProcessMessages.ALL_TRIED_COUNTS, tryNumber);
    }
}

