package bridge;

import bridge.position.Latitude;

import java.util.LinkedList;
import java.util.List;

import static bridge.position.Latitude.DOWN;
import static bridge.position.Latitude.UP;

public class GameResult {
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String MATCH = " O ";
    private static final String UNMATCHED = " X ";
    private int tryCount;
    private String success = FAIL;
    private final List<List<String>> playerPath;

    public GameResult() {
        tryCount = 1;
        playerPath = new LinkedList<>();
        playerPath.add(new LinkedList<>());
        playerPath.add(new LinkedList<>());
    }

    public void retry() {
        tryCount++;
        for (List path : playerPath) {
            path.clear();
        }
    }

    public void addPath(Latitude latitude, boolean correct) {
        String value = UNMATCHED;
        if (correct) {
            value = MATCH;
        }
        playerPath.get(latitude.ordinal()).add(value);
        int otherSide = DOWN.ordinal();
        if (latitude == DOWN) {
            otherSide = UP.ordinal();
        }
        playerPath.get(otherSide).add("   ");
    }

    public List<List<String>> getPlayerPath() {
        return playerPath;
    }

    public int getTryCount() {
        return tryCount;
    }

    public void success() {
        success = SUCCESS;
    }

    public String getSuccess() {
        return success;
    }
}
