package bridge.utils.constants;
public enum GameCommand{
    RETRY("R"),
    QUIT("Q"),
    GO_UP("U"),
    GO_DOWN("D");

    private final String command;

    GameCommand(String command){
        this.command=command;
    }

    public String getCommand() {
        return command;
    }
}