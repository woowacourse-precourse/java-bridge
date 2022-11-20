package bridge;

import bridge.MoveDirection;
import bridge.Result;

import java.util.List;

import static bridge.support.ResultSign.*;

public class ResultSignResolver {

    private final Result result;
    private StringBuilder sb;

    public ResultSignResolver(Result result) {
        this.result = result;
        this.sb = new StringBuilder();
    }

    public String resolveResult() {
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();

        for (int i = 0; i < isAnswers.size(); i++) {
            appendSignIsDownSignAnswer(isAnswers.get(i), directions.get(i));
            appendSignIsDownSignWrongAnswer(isAnswers.get(i), directions.get(i));
            appendSignIsUpSignAnswer(isAnswers.get(i), directions.get(i));
            appendSignIsUpSignWrongAnswer(isAnswers.get(i), directions.get(i));
            appendSeparatorIsNotLast(i, isAnswers.size());
        }
        return sb.toString();
    }

    private void appendSignIsDownSignAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isDownSignAnswer(isAnswer, direction)) {
            sb.append(EMPTY_SPACE.getSign());
        }
    }

    private void appendSignIsDownSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isDownSignWrongAnswer(isAnswer, direction)) {
            sb.append(EMPTY_SPACE.getSign());
        }
    }

    private void appendSignIsUpSignAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isUpSignAnswer(isAnswer, direction)) {
            sb.append(ANSWER.getSign());
        }
    }

    private void appendSignIsUpSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isUpSignWrongAnswer(isAnswer, direction)) {
            sb.append(WRONG_ANSWER.getSign());
        }
    }

    private void appendSeparatorIsNotLast(int index, int size) {
        if(index < size - 1) {
            sb.append(SEPARATOR.getSign());
        }
    }

    public static String discriminateSecondBridgeSign(Result result) {
        List<Boolean> isAnswers = result.getIsAnswers();
        List<MoveDirection> directions = result.getDirections();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < isAnswers.size(); i++) {
            if (result.isUpSignAnswer(isAnswers.get(i), directions.get(i)) || result.isUpSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(EMPTY_SPACE.getSign());
            }
            if (result.isDownSignAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(ANSWER.getSign());
            }
            if (result.isDownSignWrongAnswer(isAnswers.get(i), directions.get(i))) {
                sb.append(WRONG_ANSWER.getSign());
            }
            if (i < isAnswers.size() - 1) {
                sb.append(SEPARATOR.getSign());
            }
        }
        return sb.toString();
    }


}
