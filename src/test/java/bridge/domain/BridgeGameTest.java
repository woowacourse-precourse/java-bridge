package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {
    private static final int INIT_RETRY_COUNT = 1;

    private final List<String> randomBridge = List.of("U", "D", "U", "U");
    private final MovingStatusSaver statusSaver
            = new MovingStatusSaver(new ArrayList<>(), randomBridge);
    private final BridgeGame bridgeGame = new BridgeGame(statusSaver, INIT_RETRY_COUNT);

    @DisplayName("이동 상태 저장 테스트")
    @Test
    void validateSaveMovingStatus() {
        final List<String> movingStatus = List.of("U", "D", "U");
        for (String moving : movingStatus) {
            bridgeGame.move(moving);
        }
        assertThat(bridgeGame.getSavedStatus())
                .containsExactly("U", "D", "U");
    }
}
