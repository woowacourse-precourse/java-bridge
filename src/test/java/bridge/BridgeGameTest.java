package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame();
    }

    @Nested
    @DisplayName("다리를 전부 건넜는지 확인")
    class isSucceeded {
        @Test
        @DisplayName("다리를 전부 건넘")
        void rightCase() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "U");

            assertThat(bridgeGame.isSucceeded(bridge, moved)).isTrue();
        }

        @Test
        @DisplayName("다리 끝에 미치지 못함")
        void wrongCase1() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U");

            assertThat(bridgeGame.isSucceeded(bridge, moved)).isFalse();
        }

        @Test
        @DisplayName("다리를 건너지 못함")
        void wrongCase2() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "D");

            assertThat(bridgeGame.isSucceeded(bridge, moved)).isFalse();
        }
    }

    @Nested
    @DisplayName("다리를 건너다 실패했는지 확인하는 기능")
    class isFailed {
        @Test
        @DisplayName("다리를 건너다 실패")
        void rightCase() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "D");

            assertThat(bridgeGame.isFailed(bridge, moved)).isTrue();
        }

        @Test
        @DisplayName("다리를 건넘")
        void wrongCase() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "U");

            assertThat(bridgeGame.isFailed(bridge, moved)).isFalse();
        }
    }

    @Nested
    @DisplayName("게임이 끝났는지 확인하는 기능")
    class isFinished {
        @Test
        @DisplayName("잘못된 길을 선택해 게임이 끝남")
        void rightCase() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "D");

            assertThat(bridgeGame.isFinished(bridge, moved)).isTrue();
        }

        @Test
        @DisplayName("다리의 끝에 도달해 게임이 끝남")
        void rightCase2() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U", "U");

            assertThat(bridgeGame.isFinished(bridge, moved)).isTrue();
        }

        @Test
        @DisplayName("게임이 끝나지 않음")
        void wrongCase() {
            List<String> bridge = List.of("U", "U", "U");
            List<String> moved = List.of("U", "U");

            assertThat(bridgeGame.isFinished(bridge, moved)).isFalse();
        }
    }
}