package bridge;

import java.util.List;

public class PlayerResponseDto {

    private final List<BridgeMark> record;
    private final int attempt;

    public PlayerResponseDto(List<BridgeMark> record, int attempt) {
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
