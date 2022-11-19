package bridge;

public enum MoveAnswer {
    UP_TRUE("U","TRUE") , UP_FALSE("U","FALSE") , DOWN_TRUE("D","TRUE") , DOWN_FALSE("D","FALSE");

    public String direction;
    public String isAnswer;

    MoveAnswer(String direction, String isAnswer) {
        this.direction = direction;
        this.isAnswer = isAnswer;
    }
}
