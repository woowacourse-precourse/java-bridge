package bridge;

import java.util.List;

public class Bridge {
    private int currentPosition;
    private final List<String> availableBlocks;

    public Bridge(List<String> availableBlocks) {
        this.availableBlocks = availableBlocks;
    }

    public boolean isNextAvailable(Position position) {
        return availableBlocks.get(currentPosition + 1).equals(position);
    }

    public void movePlayer() {
        currentPosition++;
    }

    public void initializeCurrentPosition() {
        currentPosition = 0;
    }

    public boolean isLastBlock() {
        return availableBlocks.size() == currentPosition;
    }
}
