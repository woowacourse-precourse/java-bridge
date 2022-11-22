package bridge.domain.game;

import bridge.domain.bridge.Bridge;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeGameTest {
    public Bridge bridge;
    public BridgeGame bridgeGame;

    @Nested
    @DisplayName("한 번 움직였는데 정답일 경우")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class OneMove {

        @BeforeAll
        void 한_번_움직임() {
            initBridge();
            bridgeGame.move("U");
        }

        @Test
        @DisplayName("gameRoundCount는 1")
        void 라운드_카운트() {
            //given
            //when
            int result = bridgeGame.getGameRoundCount();
            // then
            assertThat(result).isEqualTo(1);
        }

        @Test
        @DisplayName("user 움직임 가능 여부는 true")
        void 유저_움직임_가능_여부() {
            //given
            // when
            boolean result = bridgeGame.isUserCanMove();
            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("GameResult의 upperBridge는 [O]")
        void 상위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getUpperBridge();
            // then
            assertThat(result).isEqualTo(List.of("O"));
        }

        @Test
        @DisplayName("GameResult의 downBridge는 [ ]")
        void 하위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getDownBridge();
            // then
            assertThat(result).isEqualTo(List.of(" "));
        }

        @Nested
        @DisplayName("재시작일 경우")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class Restart {

            @BeforeAll
            void 재시작() {
                bridgeGame.retry();
            }

            @Test
            @DisplayName("gameRoundCount는 2")
            void 라운드_카운트() {
                //given
                //when
                int result = bridgeGame.getGameRoundCount();
                // then
                assertThat(result).isEqualTo(2);
            }
        }
    }

    @Nested
    @DisplayName("두 번 움직였는데 마지막 오답인 경우")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class MoveTwice {

        @BeforeAll
        void 다_움직임() {
            initBridge();
            bridgeGame.move("U");
            bridgeGame.move("D");
        }

        @Test
        @DisplayName("user 움직임 가능 여부는 true")
        void 움직임_가능_여부() {
            //given
            // when
            boolean result = bridgeGame.isUserCanMove();
            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("GameResult의 upperBridge는 [O, ]")
        void 상위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getUpperBridge();
            // then
            assertThat(result).isEqualTo(List.of("O", " "));
        }

        @Test
        @DisplayName("GameResult의 downBridge는 [ ,X]")
        void 하위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getDownBridge();
            // then
            assertThat(result).isEqualTo(List.of(" ", "X"));
        }

    }

    @Nested
    @DisplayName("다 움직인 경우")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class MoveAll {

        @BeforeAll
        void 다_움직임() {
            initBridge();
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");
        }

        @Test
        @DisplayName("user 움직임 가능 여부는 false")
        void 움직임_가능_여부() {
            //given
            // when
            boolean result = bridgeGame.isUserCanMove();
            // then
            assertThat(result).isFalse();
        }

        @Test
        @DisplayName("GameResult의 upperBridge는 [O,O, ]")
        void 상위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getUpperBridge();
            // then
            assertThat(result).isEqualTo(List.of("O", "O", " "));
        }

        @Test
        @DisplayName("GameResult의 downBridge는 [ , , O]")
        void 하위_결과() {
            // given
            // when
            List<String> result = bridgeGame.getGameResult().getDownBridge();
            // then
            assertThat(result).isEqualTo(List.of(" ", " ", "O"));
        }

    }

    @Nested
    @DisplayName("단일 움직임 검증")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class Single {

        @BeforeAll
        void 초기화() {
            initBridge();
        }

        @Test
        @DisplayName("움직였는데 정답인 경우 true 반환")
        void 한_번_움직임_정답() {
            // given
            // when
            boolean result = bridgeGame.move("U");
            // then
            assertThat(result).isTrue();
        }

        @Test
        @DisplayName("움직였는데 오답인 경우 false 반환")
        void 한_번_움직임_오답() {
            // given
            // when
            boolean result = bridgeGame.move("D");
            // then
            assertThat(result).isFalse();
        }
    }

    void initBridge() {
        bridge = new Bridge(List.of("U", "U", "D"));
        bridgeGame = new BridgeGame(bridge);
    }


}