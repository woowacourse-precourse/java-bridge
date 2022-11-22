package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private static final List<String> list_count3 = Arrays.asList("U","D","D");
    private static final List<String> list_count1 = Arrays.asList("U");

    @Nested
    class MoveTest {
        @BeforeEach
        void setUp() {
            bridgeGame = new BridgeGame(list_count3);
        }
        @Test
        void moveTest_count3() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            List<String>[] list = bridgeGame.getResult();
            assertThat(list[0]).containsExactly("O", " ", " ");
            assertThat(list[1]).containsExactly(" ", "O" ,"O");
        }
        @Test
        void moveTest_count2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            List<String>[] list = bridgeGame.getResult();
            assertThat(list[0]).containsExactly("O", " ");
            assertThat(list[1]).containsExactly(" ", "O");
        }
    }

    @Nested
    class EndTest {
        @BeforeEach
        void setUp() {
            bridgeGame = new BridgeGame(list_count1);
        }
        @Test
        void end_true_test() {
            bridgeGame.move("U");
            assertThat(bridgeGame.isEnd()).isEqualTo(true);
        }
        @Test
        void end_false_test() {
            assertThat(bridgeGame.isEnd()).isEqualTo(false);
        }
    }
    @Nested
    class FailTest {
        @BeforeEach
        void setUp() {
            bridgeGame = new BridgeGame(list_count1);
        }
        @Test
        void is_fail_test_true() {
            BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
            bridgeGame.move("D");
            assertThat(bridgeGame.isGameFail()).isEqualTo(true);
        }
        @Test
        void is_fail_test_false() {
            BridgeGame bridgeGame = new BridgeGame(Arrays.asList("U"));
            bridgeGame.move("U");
            assertThat(bridgeGame.isGameFail()).isEqualTo(false);
        }
    }
}