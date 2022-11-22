package bridge;

public class Player {

    private Integer position;
    public Player() {
        init();
    }
    public void init() {
        position = -1;
    }
    public Integer move() {
        return ++position;
    }

    public Integer back() {
        return --position;
    }

    public Integer getPosition() {
        return position;
    }
}
