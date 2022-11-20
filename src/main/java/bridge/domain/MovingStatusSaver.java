package bridge.domain;

import java.util.List;
import java.util.Objects;

public class MovingStatusSaver {
    private final List<String> movingStatus;
    private final List<String> randomBridge;

    public MovingStatusSaver(List<String> movingStatus, List<String> randomBridge) {
        this.movingStatus = movingStatus;
        this.randomBridge = randomBridge;
    }

    public void saveMovingStatus(final String moving) {
        final boolean correctBridge = isCorrectBridge(moving);
        if (correctBridge) {
            this.movingStatus.add(moving);
        }
        if (!correctBridge) {
            this.movingStatus.add(MovingStatus.FAIL.getMovingKey() + moving);
        }
    }

    private boolean isCorrectBridge(final String moving) {
        int firstIndex = 0;
        int lastIndex = movingStatus.size();
        if (!movingStatus.isEmpty()) {
            return compareBridge(randomBridge.get(lastIndex), moving);
        }
        return compareBridge(randomBridge.get(firstIndex), moving);
    }

    private boolean compareBridge(final String bridge, final String moving) {
        return bridge.equals(moving);
    }

    public List<String> getMovingStatus() {
        return this.movingStatus;
    }

    public boolean isStopCondition() {
        if (movingStatus.contains(MovingStatus.UP.sideFail())
                || movingStatus.contains(MovingStatus.DOWN.sideFail())) {
            return true;
        }
        if (movingStatus.size() == randomBridge.size()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovingStatusSaver that = (MovingStatusSaver) o;
        return Objects.equals(movingStatus, that.movingStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movingStatus);
    }
}