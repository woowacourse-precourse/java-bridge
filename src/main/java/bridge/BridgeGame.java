package bridge;


public class BridgeGame {
    private int totalGameTrials;
    private int bridgeMovingTrials;

    public BridgeGame(){
        this.totalGameTrials=0;
        this.bridgeMovingTrials=0;
    }

    public boolean checkWinOrFail(String crossableBridge, String uOrD){
        if(crossableBridge==uOrD){
            move();
            return false;
        }
        retry();
        return true;
    }

    private void move() {
        bridgeMovingTrials+=bridgeMovingTrials;
    }

    private void retry() {
        bridgeMovingTrials=0;
        totalGameTrials+=totalGameTrials;
    }
}
