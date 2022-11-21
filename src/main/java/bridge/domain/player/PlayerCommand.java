package bridge.domain.player;

public class PlayerCommand {
    private String command;
    public PlayerCommand(String command){
        this.command = command;
    }
    public String getCommand(){
        return command;
    }
}
