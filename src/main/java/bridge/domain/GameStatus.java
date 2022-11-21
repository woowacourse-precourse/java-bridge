package bridge.domain;

public class GameStatus {
    private static boolean isCorrect;
    private static int gameCount;


    public void setMatchCorrect(boolean isCorrect){
        this.isCorrect = isCorrect;
    }

    public boolean getMatchCorrect(){
        return this.isCorrect;
    }

    public void addGameCount(){
        this.gameCount += 1;
    }

    public Integer getGameCount(){
        return this.gameCount;
    }
}
