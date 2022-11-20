package bridge;

import bridge.dto.GameResultDto;

import java.util.ArrayList;
import java.util.List;

public class Player {

    public static final int DEFAULT_GAME_ATTEMPT = 1;

    private final List<BridgeMark> record;
    private int attempt;

    public Player() {
        this.record = new ArrayList<>();
        this.attempt = DEFAULT_GAME_ATTEMPT;
    }

    public void record(BridgeMark bridgeMark) {
        record.add(bridgeMark);
    }

    public void clear() {
        record.clear();
    }

    public GameResultDto toResponseDto() {
        return new GameResultDto(new ArrayList<>(record), attempt);
    }

    public void increaseAttempt() {
        attempt++;
    }
}
