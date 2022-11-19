package bridge.dto.input;

public class ReadGameCommandDto {

    private final String gameCommand;

    public ReadGameCommandDto(String gameCommand) {
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
