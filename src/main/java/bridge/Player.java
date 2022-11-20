package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.dto.GameResultDto.GameRecord;

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

    public void clearRecord() {
        record.clear();
    }

    public void increaseAttempt() {
        attempt++;
    }

    public GameRecord toResponseDto() {
        return new GameRecord(new ArrayList<>(record), attempt);
    }
}
