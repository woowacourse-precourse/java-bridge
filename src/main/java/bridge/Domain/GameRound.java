package bridge.Domain;

public class GameRound {
    private Integer round;

    public GameRound(int round){
        this.round = round;
    }

    public GameRound firstRound(){
        return new GameRound(1);
    }

    public void getRound(){
        round++;
    }
}
