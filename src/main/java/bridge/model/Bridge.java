package bridge.model;

import java.util.List;

public class Bridge {
    private final List<String> bridge;
    private int userLocation;
    private GameResultBoard gameResultBoard;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
        this.userLocation = 0;
        this.gameResultBoard = new GameResultBoard();
    }

    public List<List<String>> getBridge() {
        return gameResultBoard.getState();
    }

    public void move() {
        this.userLocation++;
    }

    public Boolean canMove(String direction) {
        return bridge.get(userLocation - 1).equals(direction);
    }

    public Boolean arrived() {
        return userLocation >= bridge.size();
    }

    public void init() {
        this.userLocation = 0;
        this.gameResultBoard = new GameResultBoard();
    }

    public void update(String direction) {
        gameResultBoard.update(direction, canMove(direction));
    }
}
