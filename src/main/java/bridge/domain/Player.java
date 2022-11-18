package bridge.domain;

public class Player {
    private int position;
    private GameResult result;

    public Player() {
        this.position = 0;
    }

    public int getPosition() {
        return this.position;
    }

    public enum GameResult {
        SUCCESS("성공"),
        FAIL("실패");

        private String name;

        GameResult() {
        }

        GameResult(String name) {
            this.name = name;
        }
    }
}
