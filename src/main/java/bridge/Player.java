package bridge;

public class Player {
    private final int START_POSITION = -1; // 다리는 0번 인덱스부터 시작하므로 사용자의 초기화 위치는 -1이다.
    private int currentPosition;

    public Player() {
        this.currentPosition = START_POSITION;
    }

    public void move() {
        this.currentPosition++;
    }

    public int getNextPosition() {
        return this.currentPosition + 1;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }
}
