package bridge.domain.player;

public class GameCommand {
    private String gameCommand;
    public GameCommand(String gameCommand){
        this.gameCommand = gameCommand;
    }
    public String getGameCommand(){
        return gameCommand;
    }
}
