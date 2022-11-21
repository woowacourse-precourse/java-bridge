package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovingStatusSaverTest {
    private final List<String> randomBridge = List.of("U", "D", "U", "U");
    private final MovingStatusSaver saver = new MovingStatusSaver(new ArrayList<>(), randomBridge);

    @Test
    @DisplayName("마지막 이동 상태가 다른 경우")
    void validateSaveMovingStatus() {
        final List<String> movingStatus = List.of("U", "D", "U", "D");
        for (String moving : movingStatus) {
            saver.saveMovingStatus(moving);
        }
        assertThat(saver.getMovingStatus())
                .containsExactly("U", "D", "U", "-D");
    }

    @Test
    @DisplayName("입력이 랜덤 다리의 길이보다 적게 입력된 상태일 때")
    void validateMovingStatusLessThanRandom() {
        final List<String> movingStatus = List.of("U", "D");
        for (String moving : movingStatus) {
            saver.saveMovingStatus(moving);
        }
        assertThat(saver.getMovingStatus())
                .containsExactly("U", "D");
    }

    @Test
    @DisplayName("정지 조건: 건널 수 없는 다리를 선택한 경우")
    void validateIsWrongBridge() {
        final List<String> movingStatus = List.of("U", "D", "D");
        for (String moving : movingStatus) {
            saver.saveMovingStatus(moving);
        }
        assertThat(saver.isWrongBridge()).isTrue();
    }

    @Test
    @DisplayName("저장된 이동 상태의 사이즈를 반환하는 테스트")
    void validateMovingStatusSize() {
        final List<String> movingStatus = List.of("U", "D", "U");
        final int sizeResult = 3;
        for (String moving : movingStatus) {
            saver.saveMovingStatus(moving);
        }
        assertThat(saver.getStatusSize()).isEqualTo(sizeResult);
    }
}