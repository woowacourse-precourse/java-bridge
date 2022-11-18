package bridge.Domain;



public class Player {
    private int passedCount;
    private String selection;
    private boolean alive;


    public Player() {
        this.passedCount = 0;
        this.selection = null;
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

    public String getSelection() {
        return this.selection;
    }


    // setter
    public void setSelection(String selection) {
        this.selection = selection;
    }



}
