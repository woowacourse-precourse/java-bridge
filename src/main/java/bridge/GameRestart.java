package bridge;

public enum GameRestart {
    YES("R"),
    NO("Q");

    public String ans;

    GameRestart(String ans) {
        this.ans = ans;
    }

    public String getAns() {
        return ans;
    }
}
