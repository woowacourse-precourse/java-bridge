package bridge.model;

import bridge.util.BridgeGameStatus;
import bridge.util.BridgeShapeInfo;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int currentLocation;
    private List<String> upMoveMap;
    private List<String> downMoveMap;

    public Player() {
        upMoveMap = new ArrayList<>();
        downMoveMap = new ArrayList<>();
    }

    public static Player of() {
        return new Player();
    }

    public void move(String userMove, String status) {
        if (userMove.equals(BridgeShapeInfo.UP.getBridgeShape())) {
            addUpMove(status);
            return;
        }

        addDownMove(status);
    }
    public void addUpMove(String status) {
        addMoveMap(status, BridgeGameStatus.SPACEBAR.getGameStatus());
    }

    public void addDownMove(String status) {
        addMoveMap(BridgeGameStatus.SPACEBAR.getGameStatus(), status);
    }

    public void addMoveMap(String upMove, String downMove) {
        upMoveMap.add(upMove);
        downMoveMap.add(downMove);
        addCurrentLocation();
    }



    public int getCurrentLocation() {
        return currentLocation;
    }

    public void addCurrentLocation() {
        currentLocation++;
    }

    public List<String> getUpMoveMap() {
        return upMoveMap;
    }

    public List<String> getDownMoveMap() {
        return downMoveMap;
    }
}
