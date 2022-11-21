package bridge;


import java.util.List;

public class BridgeGame {
    private int totalGameTrials;
    private int bridgeMovingTrials;
    private int endOfBridges;

    public BridgeGame(List<String> crossableBridges){
        this.totalGameTrials=0;
        this.bridgeMovingTrials=0;
        this.endOfBridges = crossableBridges.size();
    }

    public String checkWinOrFail(String crossableBridge, String uOrD){
        if(crossableBridge==uOrD){
            move();
            checkGameFinished();
            return "going";
        }
        retry();
        return "fail";
    }

    private void move() {
        bridgeMovingTrials+=bridgeMovingTrials;
    }

    private void retry() {
        bridgeMovingTrials=0;
        totalGameTrials+=totalGameTrials;
    }

    private void checkGameFinished(){
        if(endOfBridges==bridgeMovingTrials){
            finish();
        }
    }
    private void finish() {

    }

}
