package bridge.dto;

import bridge.enums.BridgeMark;
import bridge.enums.GameStatus;

import java.util.List;

public class GameResultDto {

    private final GameStatus gameStatus;
    private final GameRecordDto gameRecord;

    public static class GameRecordDto {

        private final List<BridgeMark> record;
        private final int attempt;

        public GameRecordDto(List<BridgeMark> record, int attempt) {
            this.record = record;
            this.attempt = attempt;
        }

        public List<BridgeMark> getRecord() {
            return record;
        }

        public int getAttempt() {
            return attempt;
        }
    }

    public GameResultDto(GameStatus gameStatus, GameRecordDto gameRecord) {
        this.gameStatus = gameStatus;
        this.gameRecord = gameRecord;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public GameRecordDto getGameRecord() {
        return gameRecord;
    }
}
