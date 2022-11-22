package bridge.domain;

public class User {
    private int playCount;
    private boolean quit;

    public User() {
        this.playCount = 1;
        quit = false;
    }

    public int getPlayCount() {
        return this.playCount;
    }

    public boolean getQuit() {
        return this.quit;
    }

    public void setQuit() {
        this.quit = true;
    }

    public void addPlayCount() {
        this.playCount += 1;
    }
}
