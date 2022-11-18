package bridge;

import java.util.List;

public class PlayerResponseDto {

    private final List<BridgeMark> record;

    public PlayerResponseDto(List<BridgeMark> record) {
        this.record = record;
    }

    public List<BridgeMark> getRecord() {
        return record;
    }
}
