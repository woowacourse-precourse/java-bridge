package bridge;

public class MapMaker {

    private final StringBuilder[] map;

    MapMaker() {
        map = new StringBuilder[]{new StringBuilder(), new StringBuilder()};
    }

    public void setMap(String moving, String match, int position) {
        if (position != 0) {
            map[0].append("| ");
            map[1].append("| ");
        }
        setUpMap(moving, match, position);
        setDownMap(moving, match, position);
    }

    private void setUpMap(String moving, String match, int position) {
        if (moving.equals("U")) {
            map[0].append(match).append(" ");
        }
        if (moving.equals("D")) {
            map[0].append("  ");
        }
    }

    private void setDownMap(String moving, String match, int position) {
        if (moving.equals("U")) {
            map[1].append("  ");
        }
        if (moving.equals("D")) {
            map[1].append(match).append(" ");
        }
    }

    public StringBuilder[] getMap() {
        return map;
    }
}
