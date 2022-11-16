package bridge;

public enum GameState {
    SUCCESS("성공"),
    FAIL("실패");

    private final String state;
    GameState(String state){
      this.state=state;
    }

    public String getState() {
      return state;
    }

}
