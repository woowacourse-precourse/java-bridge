package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
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

    @Nested
    class MoveTest {
        @Test
        void test1() {
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', ' ', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test2() {
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("D")).isFalse();

            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', ' ', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', 'X', ' ');
        }

        @Test
        void test3() {
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test4() {
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("U")).isFalse();
            assertThat(bridgeGame.getPosition()).isEqualTo(2);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', 'X');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test5() {
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("U")).isTrue();
            assertThat(bridgeGame.move("D")).isTrue();
            assertThat(bridgeGame.getPosition()).isEqualTo(2);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', 'O');
        }
    }

}