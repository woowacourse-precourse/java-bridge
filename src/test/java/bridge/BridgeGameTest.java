package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private static final String NEXT = BridgeResultString.NEXT.getString();
    private static final String SUCCESS = BridgeResultString.SUCCESS.getString();
    private static final String FAILURE = BridgeResultString.FAILURE.getString();
    private static final String PASS = BridgeResultString.PASS.getString();

    @Nested
    @DisplayName("move 테스트")
    class MoveTest {

        @Test
        @DisplayName("move 동작 확인 1")
        void moveTest1() {
            // given
            List<String> bridge = List.of("U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(bridge);

            // when
            bridgeGame.move("U");

            // then
            assertThat(bridgeGame.getUpBridgeToString()).isEqualTo(SUCCESS);
            assertThat(bridgeGame.getDownBridgeToString()).isEqualTo(PASS);
        }

        @Test
        @DisplayName("move 동작 확인 2")
        void moveTest2() {
            // given
            List<String> bridge = List.of("U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(bridge);

            // when
            bridgeGame.move("U");
            bridgeGame.move("U");

            // then
            assertThat(bridgeGame.getUpBridgeToString()).isEqualTo(SUCCESS + NEXT + FAILURE);
            assertThat(bridgeGame.getDownBridgeToString()).isEqualTo(PASS + NEXT + PASS);
        }

        @Test
        @DisplayName("move 동작 확인 3")
        void moveTest3() {
            // given
            List<String> bridge = List.of("U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(bridge);

            // when
            bridgeGame.move("U");
            bridgeGame.move("D");

            // then
            assertThat(bridgeGame.getUpBridgeToString()).isEqualTo(SUCCESS + NEXT + PASS);
            assertThat(bridgeGame.getDownBridgeToString()).isEqualTo(PASS + NEXT + SUCCESS);
        }

        @Test
        @DisplayName("move 동작 확인 4")
        void moveTest4() {
            // given
            List<String> bridge = List.of("U", "D", "D");
            BridgeGame bridgeGame = new BridgeGame(bridge);

            // when
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");

            // then
            assertThat(bridgeGame.getUpBridgeToString()).isEqualTo(
                SUCCESS + NEXT + PASS + NEXT + PASS);
            assertThat(bridgeGame.getDownBridgeToString()).isEqualTo(
                PASS + NEXT + SUCCESS + NEXT + SUCCESS);
        }
    }
}
