package bridge.model;

import java.util.List;

public class GameDTO {
    private final List<String> bridge;
    private int nowPosition;

    public GameDTO(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getNowPosition() {
        return nowPosition;
    }

    public void setNowPosition(int nowPosition) {
        this.nowPosition = nowPosition;
    }
}
