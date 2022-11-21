package bridge;

import java.util.List;

public class Player {
    private final int START_POSITION = -1; // 다리는 0번 인덱스부터 시작하므로 사용자의 초기화 위치는 -1이다.
    private int currentPosition;
    private List<String> footprints;

    public Player() {
        this.currentPosition = START_POSITION;
    }

    public void move(String movedSide) {
        this.currentPosition++;
        footprints.add(movedSide);
    }

    public int getNextPosition() {
        return this.currentPosition + 1;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public void initializePosition() {
        currentPosition = START_POSITION;
    }

    public String getLastMoving() {
        return footprints.get(footprints.size() - 1);
    }
}
