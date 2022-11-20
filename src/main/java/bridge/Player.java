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
}
