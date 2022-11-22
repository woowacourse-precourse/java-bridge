package bridge.service;

import bridge.BridgeMaker;
import bridge.TestNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    private static BridgeGame bridgeGame;

    @BeforeEach
    void initializeBridgeGame() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0)));
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
        bridgeGame = new BridgeGame(bridge, new Player());
    }

    @DisplayName("게임 종료확인 테스트")
    @Nested
    class FinishTest {
        @DisplayName("안 떨어지고 끝까지 도착하면 종료된다")
        @Test
        void case1() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            assertThat(bridgeGame.isFinished()).isTrue();
        }

        @DisplayName("건너는 중이라면 종료된 게 아니다")
        @Test
        void case2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.isFinished()).isFalse();
        }

        @DisplayName("출발도 안 했다면 종료된 게 아니다")
        @Test
        void case3() {
            assertThat(bridgeGame.isFinished()).isFalse();
        }
    }

    @DisplayName("게임 실패확인 테스트")
    @Nested
    class FailTest {
        @DisplayName("안 떨어지고 끝까지 도착하면 실패가 아니다")
        @Test
        void case1() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            assertThat(bridgeGame.isFailed()).isFalse();
        }

        @DisplayName("건너는 중이라면 실패가 아니다")
        @Test
        void case2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.isFailed()).isFalse();
        }

        @DisplayName("출발도 안 했다면 실패가 아니다")
        @Test
        void case3() {
            assertThat(bridgeGame.isFailed()).isFalse();
        }

        @DisplayName("건너는 중에 떨어지면 실패다")
        @Test
        void case4() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.isFailed()).isTrue();
        }

        @DisplayName("다 와서 떨어져도 실패다")
        @Test
        void case5() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            assertThat(bridgeGame.isFailed()).isTrue();
        }
    }

    @DisplayName("재시작 테스트")
    @Nested
    class RetryTest {
        @DisplayName("재시작하면 실패여부도 초기화된다")
        @Test
        void failInitializeTest() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.isFailed()).isTrue();

            bridgeGame.retry();

            assertThat(bridgeGame.isFailed()).isFalse();
        }

        @DisplayName("재시작하면 이동기록도 초기화된다")
        @Test
        void crossedRecordInitializeTest() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.getCrossedRecord().get("upperCrossedRecord")).isNotEmpty();
            assertThat(bridgeGame.getCrossedRecord().get("lowerCrossedRecord")).isNotEmpty();

            bridgeGame.retry();

            assertThat(bridgeGame.getCrossedRecord().get("upperCrossedRecord")).isEmpty();
            assertThat(bridgeGame.getCrossedRecord().get("lowerCrossedRecord")).isEmpty();
        }
    }

}
