package bridge.status;

import java.util.List;

public class UserStatus {

    private final List<String> directions;
    private int position;
    private boolean available;
    private long tryCount;
    private StepType nowStep;

    public UserStatus(List<String> directions) {
        this.directions = directions;
        this.position = 0;
        this.available = true;
        this.tryCount = 1L;
    }

    public void addDirection(String direction) {
        this.directions.add(direction);
        this.position++;
    }

    public String getDirection(int index) {
        return this.directions.get(index);
    }

    public int getPosition() {
        return this.position - 1;
    }

    public String getMostRecentDirection() {
        if (this.position - 1 < 0) {
            throw new IndexOutOfBoundsException("게임을 먼저 진행해야 합니다.");
        }

        return this.directions.get(this.position - 1);
    }


    public boolean isAvailable() {
        return this.available;
    }

    public void lose() {
        this.available = false;
    }

    public long getTryCount() {
        return this.tryCount;
    }

    public void tryAgain() {
        this.directions.clear();
        this.position = 0;
        this.available = true;
        this.tryCount++;
    }


    public void changeNextStep(StepType stepType) {
        this.nowStep = stepType;
    }

    public StepType getNowStep() {
        return this.nowStep;
    }

}
