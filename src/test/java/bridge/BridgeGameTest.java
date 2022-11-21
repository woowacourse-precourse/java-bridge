package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.Status;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BridgeGameTest {
    @Nested
    class ChangeStatus {
        @DisplayName("생성된 다리와 사용자의 입력이 모두 동일한 경우 status는 SUCCESS로 변경된다.")
        @Test
        void changeStatus_SUCCESS() {
            // given
            BridgeGame bridgeGame = new BridgeGame();

            // when
            bridgeGame.changeStatus(List.of("U", "D", "D"), List.of("U", "D", "D"));

            // then
            Assertions.assertThat(bridgeGame.getStatus()).isEqualTo(Status.SUCCESS);
        }

        @DisplayName("생성된 다리와 사용자의 입력이 모두 동일하지만 아직 다 건너지 못한 경우 status는 PROCEEDING이다.")
        @Test
        void changeStatus_PROCEEDING() {
            // given
            BridgeGame bridgeGame = new BridgeGame();

            // when
            bridgeGame.changeStatus(List.of("U", "D", "D"), List.of("U"));

            // then
            Assertions.assertThat(bridgeGame.getStatus()).isEqualTo(Status.PROCEEDING);
        }

        @DisplayName("생성된 다리와 사용자의 입력이 다른 경우 status는 FAIL로 변경된다.")
        @Test
        void changeStatus_FAIL() {
            // given
            BridgeGame bridgeGame = new BridgeGame();

            // when
            bridgeGame.changeStatus(List.of("U", "D", "D"), List.of("U", "U"));

            // then
            Assertions.assertThat(bridgeGame.getStatus()).isEqualTo(Status.FAIL);
        }
    }
}
