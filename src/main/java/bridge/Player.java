package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<BridgeMark> record;

    public Player() {
        this.record = new ArrayList<>();
    }

    public void record(BridgeMark bridgeMark) {
        record.add(bridgeMark);
    }

    public void clear() {
        record.clear();
    }

    public PlayerResponseDto toResponseDto() {
        return new PlayerResponseDto(new ArrayList<>(record));
    }
}
