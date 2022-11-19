package bridge;


import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private String bridgeSize;
    private List<String> userMove=new ArrayList<>();
    private String retry;

    public void bridgeSize(String bridgeSize){
        this.bridgeSize=bridgeSize;
    }
    public void move(String userMove) {
        this.userMove.add(userMove);
    }

    public void retry(String retry){
        this.retry=retry;
    }

    public int getBridgeSize(){
        return Integer.valueOf(bridgeSize);
    }

    public List<String> getMoveList(){
        return userMove;
    }

    public String getRetry(){
        return retry;
    }





}
