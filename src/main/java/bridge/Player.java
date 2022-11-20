package bridge;

public class Player {
    private int attempt;
    private int currentSpace;

    public Player(){
        this.attempt=0;
        this.currentSpace=0;
    }

    public void increaseAttempt(){
        this.attempt+=1;
    }

    public void moveBackSpace(){
        this.currentSpace-=1;
    }

    public void moveFrontSpace(){
        this.currentSpace+=1;
    }

    public int getCurrentSpace() {
        return currentSpace;
    }
}
