package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<String> playerBridge;
    private int playCount = 1;

    public Player(){
        playerBridge = new ArrayList<>();
    }

    public void movePlayerBridge(String input){
        playerBridge.add(input);
    }

    public void movePlayerBridge(int position, String input){
        playerBridge.add(position, input);
    }

    public void resetPlayerBridge(){
        playerBridge.clear();
    }

    public List<String> getPlayerBridge(){
        return playerBridge;
    }
}
