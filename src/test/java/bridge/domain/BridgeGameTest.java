package bridge.domain;

import bridge.BridgeMaker;
import bridge.constants.Life;
import bridge.constants.Moving;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("다리의 모양이 U | D | U인 테스트")
class BridgeGameTest {
    BridgeMaker bridgeMaker;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        // given
        bridgeMaker = mock(BridgeMaker.class);
        int size = 3;
        when(bridgeMaker.makeBridge(size)).thenReturn(List.of("U", "D", "U"));
        bridgeGame = new BridgeGame(bridgeMaker, size);
    }

    @DisplayName("움직이면 position 1 증가")
    @Nested
    class MovingTest {
        @Test
        void case1() {
            // when
            bridgeGame.move();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(1);
        }

        @Test
        void case2() {
            // when
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(2);
        }

        @Test
        void case3() {
            // when
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(3);
        }
    }

    @DisplayName("마지막 움직임에 의한 생사 확인")
    @Nested
    class GettingLifeTest {
        @Test
        void case1() {
            // when
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.U)).isEqualTo(Life.SAFE);
        }

        @Test
        void case2() {
            // when
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.D)).isEqualTo(Life.SAFE);
        }

        @Test
        void case3() {
            // when
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.U)).isEqualTo(Life.SAFE);
        }

        @Test
        void case4() {
            // when
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.D)).isEqualTo(Life.DEAD);
        }

        @Test
        void case5() {
            // when
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.U)).isEqualTo(Life.DEAD);
        }

        @Test
        void case6() {
            // when
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.getLife(Moving.D)).isEqualTo(Life.DEAD);
        }
    }

    @DisplayName("게임을 클리어 했는지 테스트")
    @Nested
    class ClearTest {
        @Test
        void case1() {
            // when
            bridgeGame.move();

            // then
            assertThat(bridgeGame.isClear()).isFalse();
        }

        @Test
        void case2() {
            // when
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.isClear()).isFalse();
        }

        @Test
        void case3() {
            // when
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.move();

            // then
            assertThat(bridgeGame.isClear()).isTrue();
        }
    }

    @DisplayName("재시작을 했을 때 position이 0 인지 테스트")
    @Nested
    class RetryingTest {
        @Test
        void case1() {
            // when
            bridgeGame.retry();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(0);
        }

        @Test
        void case2() {
            // when
            bridgeGame.move();
            bridgeGame.retry();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(0);
        }

        @Test
        void case3() {
            // when
            bridgeGame.move();
            bridgeGame.move();
            bridgeGame.retry();

            // then
            assertThat(bridgeGame).extracting("position").isEqualTo(0);
        }
    }

}