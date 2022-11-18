package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(Arrays.asList("U", "U", "D"));
    }

    @DisplayName("다리의 상태를 갱신한다.")
    @Nested
    class MoveTest {
        @Test
        void test1() {
            bridgeGame.move("U");
            assertThat(bridgeGame.toString()).isEqualTo("[ O ]\n[   ]");
        }

        @Test
        void test2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.toString()).isEqualTo("[ O |   ]\n[   | X ]");
        }

        @Test
        void test3() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.toString()).isEqualTo("[ O | O ]\n[   |   ]");
        }

        @Test
        void test4() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.toString()).isEqualTo("[ O | O | X ]\n[   |   |   ]");
        }

        @Test
        void test5() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
        }
    }

    @DisplayName("게임 종료 후 재시작한다.")
    @Test
    void moveAndRetry() {
        bridgeGame.move("D");
        assertThat(bridgeGame.toString()).isEqualTo("[   ]\n[ X ]");

        bridgeGame.retry();

        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.toString()).isEqualTo("[ O | O ]\n[   |   ]");
    }

    @DisplayName("다리의 끝까지 도달하면 게임을 종료한다.")
    @Test
    void moveToTheEnd() {
        bridgeGame.move("U");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
    }
}