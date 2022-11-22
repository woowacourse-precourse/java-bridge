package bridge.DTO;

import bridge.Domain.GameResult;

import java.util.List;

public class MoveCommandDTO {
    private final List<List<GameResult>> moveCommand;

    public MoveCommandDTO(List<List<GameResult>> moveCommand) {
        this.moveCommand = moveCommand;
    }

    public List<List<GameResult>> getMoveCommand() {
        return moveCommand;
    }


}
