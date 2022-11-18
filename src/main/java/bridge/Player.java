package bridge;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<BridgeMark> record;

    public Player() {
        this.record = new ArrayList<>();
    }

    public void record(BridgeMark up) {
        record.add(up);
    }

    public PlayerResponseDto toResponseDto() {
        return new PlayerResponseDto(new ArrayList<>(record));
    }
}
