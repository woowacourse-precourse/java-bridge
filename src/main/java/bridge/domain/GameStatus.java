package bridge.domain;

import java.util.ArrayList;

public class GameStatus {
    public boolean isCorrect;
    public void setMatchCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }

    public boolean getMatchCorrect(boolean isCorrect){
        return this.isCorrect;
    }
}
