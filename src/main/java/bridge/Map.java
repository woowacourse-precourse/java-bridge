package bridge;

public class Map {

    private final String upper;
    private final String down;

    public Map(String upper, String down) {
        this.upper = upper;
        this.down = down;
    }

    public String getUpper() {
        return upper;
    }

    public String getDown() {
        return down;
    }
}
