package bridge.view;

import bridge.MoveDirection;
import bridge.Result;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        StringBuilder sb = new StringBuilder();
        printFirstBridge(sb, result);
        printSecondBridge(sb, result);
        System.out.println(sb);
    }

    private void printFirstBridge(StringBuilder sb, Result result) {
        printOpenSquareBracket(sb);
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();
        for (int i = 0; i < isAnswers.size(); i++) {
            if (result.isDownSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isDownSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isUpSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("O");
            }
            if (result.isUpSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("X");
            }
            if (i < isAnswers.size() - 1) {
                sb.append(" | ");
            }
        }
        printCloseSquareBracket(sb);
    }

    private void printSecondBridge(StringBuilder sb, Result result) {
        printOpenSquareBracket(sb);
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();
        for (int i = 0; i < isAnswers.size(); i++) {
            if (result.isUpSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isUpSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(" ");
            }
            if (result.isDownSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("O");
            }
            if (result.isDownSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append("X");
            }
            if (i < isAnswers.size() - 1) {
                sb.append(" | ");
            }
        }
        printCloseSquareBracket(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    private void printOpenSquareBracket(StringBuilder sb) {
        sb.append("[ ");
    }

    private void printCloseSquareBracket(StringBuilder sb) {
        sb.append(" ]")
          .append("\n");
    }
}
