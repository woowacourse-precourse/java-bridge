package bridge.domain;

import java.util.List;
import java.util.Objects;

public class MovingStatusSaver {
    private final List<String> movingStatus;

    public MovingStatusSaver(List<String> movingStatus) {
        this.movingStatus = movingStatus;
    }

    public void saveMovingStatus(final List<String> randomBridge, final String moving) {
        final boolean correctBridge = isCorrectBridge(randomBridge, moving);
        if (correctBridge) {
            this.movingStatus.add(moving);
        }
        if (!correctBridge) {
            this.movingStatus.add("-");
        }
    }

    private boolean isCorrectBridge(final List<String> randomBridge, final String moving) {
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
