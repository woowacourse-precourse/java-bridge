package bridge.Domain;

import bridge.Controller.Validation;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private int gameTryCount = 1;
    private boolean gameSuccess = false;
    private List<String> myMovingChoices = new ArrayList<>();
    private List<String> bridge;

    public BridgeGame(List<String> bridge){
        this.bridge = bridge;
    }

    public boolean move(String movingChoice){
        myMovingChoices.add(movingChoice);
        int presentPosition = myMovingChoices.size() - 1;
        if(myMovingChoices.get(presentPosition).equals(bridge.get(presentPosition)))
            return true;
        return false;
    }

    public boolean reachEndPosition() {
        int len = myMovingChoices.size();
        if(len == bridge.size()) {
            gameSuccess = true;
            return false;
        }
        return true;
    }

    public boolean retry(String gameCommand) {
        if(gameCommand.equals(Validation.GAME_RETRY)){
            gameTryCount += 1;
            myMovingChoices = new ArrayList<>();
            return true;
        }
        return false;
    }

    public int getGameTryCount() {
        return gameTryCount;
    }

    public boolean getGameSuccess(){
        return gameSuccess;
    }

    public List<String> getMyMovingChoices(){
        return myMovingChoices;
    }
}
