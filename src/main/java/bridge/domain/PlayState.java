package bridge.domain;

public class PlayState {
    private boolean state;

    public PlayState(boolean state) {
        this.state = state;
    }

    public boolean nowState() {
        return this.state;
    }

    public void end() {
        this.state = false;
    }
}
