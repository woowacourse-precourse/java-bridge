package bridge.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private String currentMove;
    private int currentLocation;
    private List<Map<String, String>> playerMoved;

    public Player() {
        playerMoved = new ArrayList<>();
    }
    public String getCurrentMove() {
        return currentMove;
    }

    public void setCurrentMove(String currentMove) {
        this.currentMove = currentMove;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void addPlayerMove(String move) {
        playerMoved.add(new HashMap<>(){{
            put(currentMove, move);
        }});
        addCurrentLocation();
    }

    public void addCurrentLocation() {
        currentLocation++;
    }
}
