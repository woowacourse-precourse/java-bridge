package bridge.dto;

import bridge.domain.MoveResult;
import java.util.List;

public class GameMoveDto {

    private final List<List<MoveResult>> result;

    public GameMoveDto(List<List<MoveResult>> result) {
        this.result = result;
    }

    public List<List<MoveResult>> getResult() {
        return result;
    }
}
