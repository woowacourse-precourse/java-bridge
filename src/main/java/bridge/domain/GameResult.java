package bridge.domain;

public class GameResult {
    private int numberOfAttempts = 1;
    private Bridge bridge = new Bridge();
    private GameProgress progress = GameProgress.PLAYING;

    public void retryGame() {
        cleanBridge();
        increaseAttempt();
        setProgress(GameProgress.PLAYING);
    }

    public void cleanBridge() {
        bridge = new Bridge();
    }

    public void increaseAttempt() {
        numberOfAttempts++;
    }

    public void addBlock(String upDown) {
        bridge.addBlock(upDown);
    }

    public void addBlock(Move move) {
        addBlock(move.getDirection());
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public GameProgress getProgress() {
        return progress;
    }

    public void setProgress(GameProgress progress) {
        this.progress = progress;
    }
}
