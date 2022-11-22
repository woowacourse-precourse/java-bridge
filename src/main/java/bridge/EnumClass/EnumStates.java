package bridge.EnumClass;

public enum EnumStates {
    Initialize("", 0),
    In_game("IN_GAME", 0),
    Retry("R", 0),
    Exit("실패", 0),
    Success("성공", 0),
    Index("INDEX", 0);

    private String state;
    private int worth;

    EnumStates(String state, int worth) {
        this.state = state;
        this.worth = worth;
    }

    public String getState() {
        return state;
    }

    public int getWorth() {
        return worth;
    }

    public void setWorth(int worth) {
        this.worth = worth;
    }
}
