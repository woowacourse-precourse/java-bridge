package bridge;

import dto.BridgeGameDto;
import java.util.List;

public class Bridge {
    private final List<String> bridge;

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
}
