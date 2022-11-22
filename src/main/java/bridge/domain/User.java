package bridge.domain;

public class User {
    private int playingCount;
    private boolean quit;
    public User() {
        this.playingCount = 1;
        quit = false;
    }

    public void addPlayingCount() {
        this.playingCount += 1;
    }

    public int getPlayingCount() {
        return this.playingCount;
    }

    public void setQuit() {
        this.quit = true;
    }
}