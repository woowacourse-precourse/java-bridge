package bridge.Model;



public class Player {
    private int passedCount;
    private boolean alive;


    public Player() {
        this.passedCount = 0;
        this.alive = true;
    }


    public void die() {
        this.alive = false;
    }

    public void success() {
        this.passedCount++;
    }

    public void revive() {
        this.alive = true;
        this.passedCount = 0;
    }

    // getter
    public boolean isAlive() {
        return this.alive;
    }

    public int getPassedCount() {
        return this.passedCount;
    }
}
