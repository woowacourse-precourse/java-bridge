package bridge;

public class Player {
    private int location = 0;

    private String lastMoving;

    public int getLocation() {
        return this.location;
    }

    public String getLastMoving() {
        return lastMoving;
    }

    public void setLastMoving(String lastMoving) {
        this.lastMoving = lastMoving;
    }

    /**
     * 현재 위치를 1 증가시킨다.
     */
    public void locationUpdate() {
        this.location++;
    }
}
