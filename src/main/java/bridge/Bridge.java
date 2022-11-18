package bridge;

import java.util.List;

public class Bridge {
    private int playerPosition;
    private final List<String> availableBlocks;

    public Bridge(List<String> availableBlocks) {
        this.availableBlocks = availableBlocks;
    }

    public boolean isNextAvailable(Position position) {
        return availableBlocks.get(playerPosition + 1).equals(position);
    }

    public void movePlayer() {
        playerPosition++;
    }
}
