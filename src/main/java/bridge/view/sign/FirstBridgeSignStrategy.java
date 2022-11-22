package bridge.view.sign;

import bridge.domain.MoveDirection;
import bridge.domain.Result;

import static bridge.view.sign.ResultSign.*;

public class FirstBridgeSignStrategy implements SignStrategy {

    private final Result result;
    private final StringBuilder sb;

    public FirstBridgeSignStrategy(Result result, StringBuilder sb) {
        this.result = result;
        this.sb = sb;
    }

    @Override
    public void appendSignIsDownSignAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isDownSignAnswer(isAnswer, direction)) {
            sb.append(EMPTY_SPACE.getSign());
        }
    }

    @Override
    public void appendSignIsDownSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isDownSignWrongAnswer(isAnswer, direction)) {
            sb.append(EMPTY_SPACE.getSign());
        }
    }

    @Override
    public void appendSignIsUpSignAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isUpSignAnswer(isAnswer, direction)) {
            sb.append(ANSWER.getSign());
        }
    }

    @Override
    public void appendSignIsUpSignWrongAnswer(boolean isAnswer, MoveDirection direction) {
        if (result.isUpSignWrongAnswer(isAnswer, direction)) {
            sb.append(WRONG_ANSWER.getSign());
        }
    }

    @Override
    public void appendSeparatorIsNotLast(int index, int size) {
        if (index < size - 1) {
            sb.append(SEPARATOR.getSign());
        }
    }
}
