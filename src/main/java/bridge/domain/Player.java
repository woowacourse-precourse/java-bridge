package bridge.domain;

public class Player {

    private String latestMoving;
    private int position = -1;

    public void move(String moving) {
        latestMoving = moving;
        position++;
    }

    public String getLatestMoving() {
        if (position < 0) {
            throw new IllegalStateException("아직 이동하지 않았습니다. 한번 이상은 이동 해야 합니다.");
        }

        return latestMoving;
    }

    public int getPosition() {
        return position;
    }

    public void reset() {
        latestMoving = null;
        position = -1;
    }
}
