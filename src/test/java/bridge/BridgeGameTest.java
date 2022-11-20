package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        bridgeGame = new BridgeGame(new Bridge(Arrays.asList("U", "U", "D")));
    }

    @DisplayName("다리의 Map을 확인한다.")
    @Nested
    class MoveTest {

        @Test
        void test1() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            assertThat(bridgeGame.toString()).isEqualTo("[ O ]\n[   ]");
        }

        @Test
        void test2() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            bridgeGame.move("D");
            assertThat(bridgeGame.getPosition()).isEqualTo(-2);
            assertThat(bridgeGame.toString()).isEqualTo("[ O |   ]\n[   | X ]");
        }

        @Test
        void test3() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            assertThat(bridgeGame.toString()).isEqualTo("[ O | O ]\n[   |   ]");
        }

        @Test
        void test4() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(-2);

            assertThat(bridgeGame.toString()).isEqualTo("[ O | O | X ]\n[   |   |   ]");
        }

        @Test
        void test5() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            bridgeGame.move("D");
            assertThat(bridgeGame.getPosition()).isEqualTo(2);
            assertThat(bridgeGame.toString()).isEqualTo("[ O | O |   ]\n[   |   | O ]");
        }
    }

}