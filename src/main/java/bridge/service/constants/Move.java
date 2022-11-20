package bridge.service.constants;

public enum Move {

    UPBRIDGE("U"),
    DOWNBRIDGE("D");

    private final String moveBridge;

    Move(String moveBridge){
        this.moveBridge = moveBridge;
    }

    public String getMoveBridge(){
        return moveBridge;
    }
}
