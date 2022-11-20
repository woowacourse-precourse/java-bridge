package bridge;

public interface SignStrategy {
    void appendSignIDownSignAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIDownSignWrongAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIUpSignAnswer(boolean isAnswer, MoveDirection direction);

    void appendSignIUpSignWrongAnswer(boolean isAnswer, MoveDirection direction);

    void appendSeparatorIsNotLast(int index, int size);
}
