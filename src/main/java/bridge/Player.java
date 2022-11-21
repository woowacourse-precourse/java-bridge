package bridge;

public class Player {


    private int attempt;
    private int currentLocation; //TODO curLocation으로 변경

    private int winOrLose;
    private static final int WIN = 1;
    private static final int LOSE = -1;
    private static final int NOT_PENDED = 0;

    public Player(){
        this.attempt=1;
        this.currentLocation =0;
        this.winOrLose=NOT_PENDED;
    }

    public Player(int attempt, int currentLocation){
        this.attempt=attempt;
        this.currentLocation = currentLocation;
        this.winOrLose=NOT_PENDED;
    }

    public void increaseAttempt(){
        this.attempt+=1;
    }

    public void moveBackSpace(){
        this.currentLocation -=1;
    }

    public void moveFrontSpace(){
        this.currentLocation +=1;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void lose(){
        winOrLose=LOSE;
    }

    public void win(){
        winOrLose=WIN;
    }

    public boolean isPlayerWin(){
        if(winOrLose==WIN) {
            return true;
        }
        return false;
    }

    public int getAttempt() {
        return attempt;
    }
}
