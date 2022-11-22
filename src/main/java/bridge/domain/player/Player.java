package bridge.domain.player;

public class Player {
    private MoveCommand moveCommand;
    private PlayerCommand playerCommand;
    public void setInputMoving(String command){
        moveCommand = new MoveCommand(command);
    }
    public void setPlayerCommand(String command){
        playerCommand = new PlayerCommand(command);
    }
    public MoveCommand getMoveCommand(){
        return moveCommand;
    }
    public PlayerCommand getPlayerCommand(){
        return playerCommand;
    }
}
