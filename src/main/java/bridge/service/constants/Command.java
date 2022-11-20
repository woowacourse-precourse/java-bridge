package bridge.service.constants;

public enum Command {
    RETRY("R"),
    QUIT("Q");

    private final String commandGame;

    Command(String commandGame){
        this.commandGame = commandGame;
    }

    public String getCommandGame(){
        return commandGame;
    }
}
