package bridge.model;

public enum GameCondition {

    RESTART("R"),
    QUIT("Q");

    private final String condition;

    GameCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return condition;
    }

}
