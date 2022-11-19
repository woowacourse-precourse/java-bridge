package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStatusSaverTest {
    private final MovingStatusSaver saver = new MovingStatusSaver(new ArrayList<>());
    private final List<String> randomBridge = List.of("U", "D", "U");

    @Test
    @DisplayName("마지막 이동 상태가 다른 경우")
    void validateSaveMovingStatus() {
        final List<String> movingStatus = List.of("U", "D", "D");
        for (String moving : movingStatus) {
            saver.saveMovingStatus(randomBridge, moving);
        }
        assertThat(saver.getMovingStatus())
                .containsExactly("U", "D", "-D");
    }

    @Test
    @DisplayName("입력이 랜덤 다리의 길이보다 적게 입력된 상태일 때")
    void validateMovingStatusLessThanRandom() {
        final List<String> movingStatus = List.of("U", "D");
        for (String moving : movingStatus) {
            saver.saveMovingStatus(randomBridge, moving);
        }
        assertThat(saver.getMovingStatus())
                .containsExactly("U", "D");
    }
}
