package bridge.DTO;

import bridge.Domain.FinalGameResult;
import bridge.Domain.GameResult;

public class GameResultDTO {
    private final FinalGameResult finalGameResult;
    private final MoveCommandDTO moveCommandDTO;
    private final int count;


    public GameResultDTO(FinalGameResult finalGameResult, MoveCommandDTO moveCommandDTO, int count) {
        this.finalGameResult = finalGameResult;
        this.moveCommandDTO = moveCommandDTO;
        this.count = count;
    }

    public FinalGameResult getFinalGameResult() {
        return finalGameResult;
    }

    public MoveCommandDTO getMoveCommandDTO() {
        return moveCommandDTO;
    }

    public int getCount() {
        return count;
    }
}