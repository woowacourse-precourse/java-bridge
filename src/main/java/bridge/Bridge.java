package bridge;

import dto.BridgeDto;
import dto.BridgeGameDto;
import java.util.List;

public class Bridge {
    private final List<String> bridge;
    public static final String ERROR_BRIDGE_SIZE = "[ERROR] 다리 길이는 3 이상 20 이하입니다.";

    public Bridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public boolean isCorrectGuess(BridgeGameDto bridgeGameDto) {
        int currentPosition = bridgeGameDto.currentPosition;
        String answer = bridge.get(currentPosition);
        String guess = bridgeGameDto.direction;

        if (guess.equals(answer)) {
            return true;
        }
        return false;
    }

    public int size() {
        return bridge.size();
    }

    public BridgeDto sendDto() {
        return new BridgeDto(this.bridge);
    }
}
