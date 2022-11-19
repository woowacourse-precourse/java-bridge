package bridge;


import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private String bridgeSize;
    private List<String> userMove=new ArrayList<>();
    private String retry;
    private List<String> bridge=new ArrayList<>();

    public void bridgeSize(String bridgeSize){
        this.bridgeSize=bridgeSize;
    }
    public void move(String userMove) {
        this.userMove.add(userMove);
    }

    public void retry(String retry){
        this.retry=retry;
    }

    public void bridge(List<String>bridge){
        this.bridge=bridge;
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
