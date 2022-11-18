package bridge;

import bridge.dto.PlayerResponseDto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<BridgeMark> record;
    private int attempt;

    public Player() {
        this.record = new ArrayList<>();
        this.attempt = 1;
    }

    public void record(BridgeMark bridgeMark) {
        record.add(bridgeMark);
    }

    public void clear() {
        record.clear();
    }

    public PlayerResponseDto toResponseDto() {
        return new PlayerResponseDto(new ArrayList<>(record), attempt);
    }

    public void increaseAttempt() {
        attempt++;
    }
}
