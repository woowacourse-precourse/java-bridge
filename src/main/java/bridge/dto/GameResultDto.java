package bridge.dto;

import bridge.BridgeMark;

import java.util.List;

public class GameResultDto {

    private final List<BridgeMark> record;
    private final int attempt;

    public GameResultDto(List<BridgeMark> record, int attempt) {
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
