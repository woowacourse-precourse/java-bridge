package bridge.Domain;

import bridge.Controller.Validation;

import java.util.ArrayList;
import java.util.List;

public class BridgeGame {

    private int gameTryCount = 1;
    private boolean gameSuccess = false;
    private List<String> myMovingChoices = new ArrayList<>();
    private Bridge bridge;

    public BridgeGame(Bridge bridge){
        this.bridge = bridge;
    }

    public boolean move(Moving movingChoice){
        myMovingChoices.add(movingChoice.getMoving());
        int presentPosition = myMovingChoices.size() - 1;
        if(myMovingChoices.get(presentPosition).equals(bridge.getBridge().get(presentPosition)))
            return true;
        return false;
    }

    public boolean reachEndPosition() {
        int len = myMovingChoices.size();
        if(len == bridge.getBridge().size()) {
            gameSuccess = true;
            return false;
        }
        return true;
    }

    public boolean retry(GameCommand gameCommand) {
        if(gameCommand.getCommand().equals(Validation.GAME_RETRY)){
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
