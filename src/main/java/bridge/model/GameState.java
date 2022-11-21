package bridge.model;

public enum GameState {
    Over("실패"),
    Playing("진행중"),
    Success("성공");

    private final String state;

    private GameState(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}
