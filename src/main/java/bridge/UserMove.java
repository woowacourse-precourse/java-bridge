package bridge;

import java.util.ArrayList;
import java.util.List;

public class UserMove {
    private int tryCount=0;
    private int moveCount=0;

    public int getMoveCount() {
        return moveCount;
    }
    public void increaseMoveCount(){
        moveCount++;
    }

    private List<String> userLocation=new ArrayList<>();

    public void increaseTryCount(){
        tryCount++;
    }

    public void moveUser(String bridge){
        userLocation.add(bridge);
    }

    public List<String> getUserLocation() {
        return userLocation;
    }
}
