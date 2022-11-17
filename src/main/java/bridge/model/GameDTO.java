package bridge.model;

import java.util.List;

public class GameDTO {
    private final List<Character> bridge;
    private int nowPosition;

    public GameDTO(List<Character> bridge) {
        this.bridge = bridge;
    }

    public int getNowPosition() {
        return nowPosition;
    }

    public void setNowPosition(int nowPosition) {
        this.nowPosition = nowPosition;
    }
}
