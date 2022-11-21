package bridge.domain;

public class Player {
    private int position;
    private int totalTryNumber;
    private Result result;

    public Player() {
        this.position = 0;
        this.result = Result.PLAYING;
    }

    public void init() {
        this.position = 0;
        this.result = Result.PLAYING;
    }

    public void move() {
        this.position += 1;
    }

    public void tryGame() {
        this.totalTryNumber += 1;
    }

    public void fail() {
        this.result = Result.FAIL;
    }

    public void success() {
        this.result = Result.SUCCESS;
    }

    public boolean isGameOver() {
        return !result.equals(Result.PLAYING);
    }

    public int nowPosition() {
        return this.position;
    }

    public int getTotalTryNumber() {
        return this.totalTryNumber;
    }

    public Result getResult() {
        return result;
    }

    public enum Result {
        SUCCESS("성공"),
        FAIL("실패"),
        PLAYING("진행중");

        private final String name;

        Result(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
