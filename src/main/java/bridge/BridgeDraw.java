package bridge;

import game.BridgeGame;

import java.util.ArrayList;
import java.util.List;

public class BridgeDraw {

    private List<String> upMap = new ArrayList<>();

    private List<String> downMap = new ArrayList<>();

    public List<String> getUpMap() {
        return upMap;
    }

    public List<String> getDownMap() {
        return downMap;
    }

    public void saveSuccessMoving(String user) {
        if (user.equals("U")) {
            upMap.add(" O ");
            downMap.add("   ");
        }
        if (user.equals("D")) {
            upMap.add("   ");
            downMap.add(" O ");
        }
    }

    public void saveFailMoving(String user) {
        if (user.equals("U")) {
            upMap.add(" X ");
            downMap.add("   ");
        }
        if (user.equals("D")) {
            upMap.add("   ");
            downMap.add(" X ");
        }
    }

    public void reset() {
        upMap = new ArrayList<>();
        downMap = new ArrayList<>();
    }
}
