package bridge;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private final int size;
    private int location = 0;
    private int tryCount = 1;
    private boolean correct;

    public Bridge(List<String> bridge, int size) {
        this.bridge = bridge;
        this.size = size;
    }

    /**
     * 이동 가능한지 여부를 확인한다.
     */
    public boolean possibleMove(String moving) {
        return getAnswer(location).equals(moving);
    }

    /**
     * 현재 위치를 1 증가시킨다.
     */
    public void locationUpdate() {
        this.location++;
    }

    /**
     * 트라이 횟수를 1 증가시킨다.
     */
    public void tryCountUpdate() {
        this.tryCount++;
    }

    /**
     * 현재 위치의 정답을 가져온다.
     */
    private String getAnswer(int current) {
        return this.bridge.get(current);
    }

    public int getLocation() {
        return this.location;
    }

    public int getTryCount() {
        return this.tryCount;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    /**
     * 현재 진행도에 따른 다리 출력물을 반환한다.
     */
    public String getProgress() {
            return null;
    }
}
