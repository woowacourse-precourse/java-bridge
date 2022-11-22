package bridge.Domain;

import bridge.Controller.Validation;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    public int gameTryCount = 1;
    public boolean gameSuccess = false;
    public List<String> mySelectBridge = new ArrayList<>();
    List<String> bridge;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean gamePlayOnce(String position) {
        int len = mySelectBridge.size();
        mySelectBridge.add(position);
        if (mySelectBridge.get(len).equals(bridge.get(len))){
            return true;
        }
        return false;
    }

    public boolean move() {
        int len = mySelectBridge.size();
        if(len == bridge.size()) {
            gameSuccess = true;
            return false;
        }
        return true;
    }

    public boolean retry(String gameCommand) {
        if(gameCommand.equals(Validation.GAME_RETRY)){
            gameTryCount += 1;
            mySelectBridge = new ArrayList<>();
            return true;
        }
        return false;
    }
}
