package bridge.view.sign;

import bridge.domain.MoveDirection;

public interface SignStrategy {
    void appendSignIsDownSignAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIsDownSignWrongAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIsUpSignAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIsUpSignWrongAnswer(boolean isAnswer, MoveDirection direction);

    void appendSeparatorIsNotLast(int index, int size);
}
