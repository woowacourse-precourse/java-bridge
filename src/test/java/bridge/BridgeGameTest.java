package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("BridgeGame 클래스")
public class BridgeGameTest {

    @Nested
    @DisplayName("move 메서드는")
    class Describe_move {

        @Nested
        @DisplayName("Bridge가 U를 가진 상황에서")
        class Context_with_U {
            private BridgeGame bridgeGame = new BridgeGame(List.of(BridgeType.U));

            @Test
            @DisplayName("U가 입력되면 PASS를 반환한다")
            void it_input_U_then_returns_PASS() {
                Assertions.assertThat(bridgeGame.move(BridgeType.U))
                        .isEqualTo(MoveResult.PASS);
            }

            @Test
            @DisplayName("D가 입력되면 FAIL을 반환한다")
            void it_input_U_then_returns_FAIL() {
                Assertions.assertThat(bridgeGame.move(BridgeType.D))
                        .isEqualTo(MoveResult.FAIL);
            }
        }
    }

}
