package bridge;

import bridge.dto.BridgeDto;
import bridge.dto.BridgeGameDto;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectGuess(BridgeGameDto bridgeGameDto) {
        int currentPosition = bridgeGameDto.currentPosition;
        Direction answer = Direction.of(bridge.get(currentPosition));
        Direction guess = bridgeGameDto.direction;
        return guess.equals(answer);
    }

    public int size() {
        return bridge.size();
    }

    public BridgeDto sendDto() {
        return new BridgeDto(this.bridge);
    }
}
