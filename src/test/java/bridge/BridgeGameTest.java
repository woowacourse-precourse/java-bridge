package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

    @Nested
    @DisplayName("생성자 테스트")
    class testConstructor {

        @DisplayName("성공")
        @Test
        void testConstructor() {
            List<String> answerBridge = List.of("U", "D", "D", "D");
            new BridgeGame(answerBridge);
        }
    }

    @Nested
    @DisplayName("다리 이동 테스트")
    class testMove {

        @DisplayName("성공")
        @Test
        void testMove() {
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

            BridgeMap bridgeMap = bridgeGame.move("U");
            assertThat(bridgeMap.getBridgeUp()).isEqualTo("[ O ]");
            assertThat(bridgeMap.getBridgeDown()).isEqualTo("[   ]");
        }

        @DisplayName("실패")
        @Test
        void testMoveFail() {
            BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "D"));

            BridgeMap bridgeMap = bridgeGame.move("D");
            assertThat(bridgeMap.getBridgeUp()).isEqualTo("[   ]");
            assertThat(bridgeMap.getBridgeDown()).isEqualTo("[ X ]");
        }
    }
}
