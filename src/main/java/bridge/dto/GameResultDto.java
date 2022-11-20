package bridge.dto;

import bridge.constant.BridgeMark;
import bridge.constant.GameStatus;

import java.util.List;

public class GameResultDto {

    private final GameStatus gameStatus;
    private final GameRecord gameRecord;

    public static class GameRecord {

        private final List<BridgeMark> record;
        private final int attempt;

        public GameRecord(List<BridgeMark> record, int attempt) {
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

    public GameResultDto(GameStatus gameStatus, GameRecord gameRecord) {
        this.gameStatus = gameStatus;
        this.gameRecord = gameRecord;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public GameRecord getGameRecord() {
        return gameRecord;
    }
}
