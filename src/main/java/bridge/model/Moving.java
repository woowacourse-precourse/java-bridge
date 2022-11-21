package bridge.model;

public enum Moving {
    cant(0, "X"),
    can(1, "O");

    final private Integer movingNum;
    final private String movingResult;

    public Integer getMovingNum() {
        return movingNum;
    }

    public String getMovingResult() {
        return movingResult;
    }

    Moving(Integer movingNum, String movingResult) {
        this.movingNum = movingNum;
        this.movingResult = movingResult;
    }
}
