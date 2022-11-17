package bridge;

public class Bridges {
    private final int size;

    public Bridges(int size) {
        this.size = size;
    }

    public boolean isEnd(Player player) {
        return player.isCompleted(size-1);
    }
}
