package bridge.dto.input;

public class ReadMovingDto {

    private final String movingCommand;

    public ReadMovingDto(String movingCommand) {
        this.movingCommand = movingCommand;
    }

    public String getMovingCommand() {
        return movingCommand;
    }
}
