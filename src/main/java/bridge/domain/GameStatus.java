package bridge.domain;

import java.util.ArrayList;

public class GameStatus {
    private boolean isCorrect;
    private int gameCount;


    public void setMatchCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }

    public boolean getMatchCorrect(boolean isCorrect){
        return this.isCorrect;
    }

    public void addGameCount(boolean gameCount){
        this.gameCount += 1;
    }

    public Integer getGameCount(){
        return this.gameCount;
    }
}
