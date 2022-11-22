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
}