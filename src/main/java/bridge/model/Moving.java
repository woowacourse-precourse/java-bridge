package bridge.model;

public enum Moving {
    down(0, "D"),
    up(1, "U");

    final private Integer movingNum;
    final private String movingCommand;

    public Integer getMovingNum() {
        return movingNum;
    }

    public String getMovingCommand() {
        return movingCommand;
    }

    Moving(Integer movingNum, String movingCommand) {
        this.movingNum = movingNum;
        this.movingCommand = movingCommand;
    }
}
