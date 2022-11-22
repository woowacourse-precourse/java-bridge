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

    public void locationUpdate() {
        this.location++;
    }
}
