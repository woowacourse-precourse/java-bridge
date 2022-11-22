package bridge.Model;



public class Player {
    private int passedCount;
    private boolean alive;


    public Player() {
        this.passedCount = 0;
        this.alive = true;
    }


    public void die() {
        alive = false;
    }

    public void success() {
        passedCount++;
    }

    public void revive() {
        alive = true;
        passedCount = 0;
    }

    // getter
    public boolean isAlive() {
        return alive;
    }

    public int getPassedCount() {
        return passedCount;
    }
}
