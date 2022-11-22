package bridge.domain;

import java.util.ArrayList;
import java.util.List;

import bridge.constant.Direction;

/**
 * 플레이어의 선택을 관리하는 클래스
 */
public class PlayerChoice {
    List<Direction> choices;

    public PlayerChoice() {
        choices = new ArrayList<Direction>();
    }

    public void add(Direction direction) {
        choices.add(direction);
    }

    public void clear() {
        choices.clear();
    }

    public boolean isValid(List<String> bridgeAnswer) {
        for (int index = 0; index < choices.size(); index++) {
            Direction choice = choices.get(index);
            Direction answer = Direction.getDirection(bridgeAnswer.get(index));

            if (!choice.equals(answer)) {
                return false;
            }
        }

        return true;
    }

    public boolean isArrived(List<String> bridgeAnswer) {
        int lastIndex = bridgeAnswer.size() - 1;
        Direction lastAnswer = Direction.getDirection(bridgeAnswer.get(lastIndex));

        if (choices.size() == bridgeAnswer.size() && choices.get(lastIndex) == lastAnswer) {
            return true;
        }

        return false;
    }

    public String toStringWith(List<String> bridgeAnswer, Direction direction) {
        StringBuilder steps = new StringBuilder();

        for (int index = 0; index < choices.size(); index++) {
            String step = makeStepString(bridgeAnswer, direction, index);
            steps.append(step);
        }

        return "[" + steps.toString() + "]";
    }

    private String makeStepString(List<String> bridgeAnswer, Direction direction, int index) {
        Direction choice = choices.get(index);
        StringBuilder step = new StringBuilder();
        drawLineToStep(step, index);
        drawBlankToStep(step, choice, direction);

        if (choice.equals(direction)) {
            drawResultToStep(step, choice, Direction.getDirection(bridgeAnswer.get(index)));
        }

        return step.toString();
    }

    private void drawLineToStep(StringBuilder step, int index) {
        if (index != 0) {
            step.append("|");
        }
    }

    private void drawBlankToStep(StringBuilder step, Direction choice, Direction direction) {
        if (!choice.equals(direction)) {
            step.append("   ");
        }
    }

    private void drawResultToStep(StringBuilder step, Direction choice, Direction bridgeAnswerDirection) {
        if (choice.equals(bridgeAnswerDirection)) {
            step.append(" O ");
        }

        if (!choice.equals(bridgeAnswerDirection)) {
            step.append(" X ");
        }
    }
}