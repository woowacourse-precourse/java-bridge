package bridge.view;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final String OPEN_BRACKET = "[";
    private final String CLOSE_BRACKET = "]";
    private final String CORRECT = " O ";
    private final String WRONG = " X ";
    private final String SEPARATOR = "|";
    private final String SPACE = "   ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(GameResult gameResult) {
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

        createMap(line1, line2, gameResult);

        System.out.println(line1);
        System.out.println(line2);
    }

    private void createMap(StringBuilder line1, StringBuilder line2, GameResult gameResult) {
        List<String> bridge = gameResult.getResult();

        appendExceptLast(line1, line2, bridge);
        appendLast(line1, line2, gameResult);
    }


    private void appendLast(StringBuilder line1, StringBuilder line2, GameResult result) {
        ViewStatus status = result.getNextViewStatus();
        List<String> bridge = result.getResult();
        String lastPosition = bridge.get(bridge.size() - 1);
        if (status == ViewStatus.DETERMINE_CONTINUE) {
            appendLastWhenWrong(lastPosition, line1, line2);
            return;
        }
        appendLastWhenCorrect(lastPosition, line1, line2);
    }

    private void appendLastWhenCorrect(String lastPosition, StringBuilder line1, StringBuilder line2) {
        appendUpLastWhenCorrect(line1, lastPosition);
        appendDownLastWhenCorrect(line2, lastPosition);
    }

    private void appendUpLastWhenCorrect(StringBuilder line, String lastPosition) {
        if (lastPosition.equals("U")) {
            line.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendDownLastWhenCorrect(StringBuilder line, String lastPosition) {
        if (lastPosition.equals("D")) {
            line.append(CORRECT).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }


    private void appendLastWhenWrong(String lastPosition, StringBuilder line1, StringBuilder line2) {
        appendUpLastWhenWrong(lastPosition, line1);
        appendDownLastWhenWrong(lastPosition, line2);
    }

    private void appendDownLastWhenWrong(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("U")) {
            line.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendUpLastWhenWrong(String lastPosition, StringBuilder line) {
        if (lastPosition.equals("D")) {
            line.append(WRONG).append(CLOSE_BRACKET);
            return;
        }
        line.append(SPACE).append(CLOSE_BRACKET);
    }

    private void appendExceptLast(StringBuilder line1, StringBuilder line2, List<String> bridge) {
        line1.append(OPEN_BRACKET);
        line2.append(OPEN_BRACKET);
        for (int index = 0; index < bridge.size() - 1; index++) {
            String currentPosition = bridge.get(index);
            appendUp(line1, currentPosition);
            appendDown(line2, currentPosition);
        }
    }

    private void appendUp(StringBuilder line, String position) {
        if (position.equals("U")) {
            line.append(CORRECT).append(SEPARATOR);
            return;
        }
        line.append(SPACE).append(SEPARATOR);
    }

    private void appendDown(StringBuilder line, String position) {
        if (position.equals("D")) {
            line.append(CORRECT).append(SEPARATOR);
            return;
        }
        line.append(SPACE).append(SEPARATOR);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
