package bridge;

public enum GameState {
    WIN(1),ALIVE(2),FALL(3),START(2)
    ,RETRY(4);

    private final int value;
    GameState(int value){
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
