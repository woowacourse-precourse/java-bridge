package bridge.dto;

public class GameCommandDTO {
    private final String gameCommand;
    
    public GameCommandDTO(final String gameCommand) {
        this.gameCommand = gameCommand;
    }
    
    public String getGameCommand() {
        return gameCommand;
    }
}
