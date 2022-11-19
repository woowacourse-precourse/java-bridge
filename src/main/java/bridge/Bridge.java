package bridge;

import java.util.List;

public class Bridge {
    private int currentPosition;
    private final List<String> availableBlocks;

    public Bridge(List<String> availableBlocks) {
        this.availableBlocks = availableBlocks;
        this.currentPosition = -1;
    }

    public boolean isNextAvailable(String position) {
        return availableBlocks.get(currentPosition + 1).equals(position);
    }

    public void movePlayer() {
        currentPosition++;
    }

    public void initializeCurrentPosition() {
        currentPosition = -1;
    }

    public boolean isLastBlock() {
        return availableBlocks.size() == currentPosition;
    }
}
