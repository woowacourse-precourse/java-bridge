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

    public void addTotalTryNumber() {
        this.totalTryNumber += 1;
    }

    public void fail() {
        this.result = Result.FAIL;
    }

    public void success() {
        this.result = Result.SUCCESS;
    }

    public boolean isPlaying() {
        return result.equals(Result.PLAYING);
    }

    public int getCurrentPosition() {
        return this.position;
    }

    public int getTotalTryNumber() {
        return this.totalTryNumber;
    }

    public String getGameResult() {
        return result.getName();
    }

    public boolean isFail() {
        return this.result.equals(Result.FAIL);
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
