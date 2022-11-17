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
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(0);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', ' ', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', ' ', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', 'X', ' ');
        }

        @Test
        void test3() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(1);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test4() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.getPosition()).isEqualTo(2);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', 'X');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', ' ');
        }

        @Test
        void test5() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.getPosition()).isEqualTo(2);
            assertThat(bridgeGame.getUpBridgeStatus()).containsExactly('O', 'O', ' ');
            assertThat(bridgeGame.getDownBridgeStatus()).containsExactly(' ', ' ', 'O');
        }
    }

}