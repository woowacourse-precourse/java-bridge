package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.domain.vo.BridgeSize;
import bridge.domain.vo.MoveCommand;
import bridge.domain.vo.RetryCommand;
import bridge.dto.GameResult;
import bridge.dto.MoveResult;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;

    @BeforeEach
    private void init() {
        bridgeGame = BridgeGame.of(new MockBridgeGameRepository(), new MockBridgeMaker(), new BridgeSize(3));
    }

    @DisplayName("move로 생성된 MoveResult는")
    @Nested
    class Move {

        @DisplayName("이동 결과가")
        @Nested
        class isSuccess {

            @DisplayName("성공이면 true를 가진다.")
            @Test
            public void When_MoveIsSuccess_Expect_True() {
                MoveResult moveResult = bridgeGame.move(new MoveCommand("U"));
                assertThat(moveResult.isSuccess()).isTrue();
            }
            @DisplayName("실패면 false를 가진다.")
            @Test
            public void When_MoveIsNotSuccess_Expect_False() {
                MoveResult moveResult = bridgeGame.move(new MoveCommand("D"));
                assertThat(moveResult.isSuccess()).isFalse();
            }
        }

        @DisplayName("입력한 메시지가")
        @Nested
        class inputMessage {

            @DisplayName("U이면 U를 가진다.")
            @Test
            public void When_InputMessageIsU_Expect_MoveResultContainU() {
                MoveResult moveResult = bridgeGame.move(new MoveCommand("U"));
                assertThat(moveResult.getMessage()).isEqualTo("U");
            }

            @DisplayName("D이면 d를 가진다.")
            @Test
            public void When_InputMessageIsD_Expect_MoveResultContainD() {
                MoveResult moveResult = bridgeGame.move(new MoveCommand("D"));
                assertThat(moveResult.getMessage()).isEqualTo("D");
            }
        }
    }

    @DisplayName("RetryCommand가")
    @Nested
    class Retry {

        @DisplayName("R이면 True를 반환한다")
        @Test
        public void When_RetryCommandIsR_Expect_True() {
            boolean result = bridgeGame.retry(new RetryCommand("R"));
            assertThat(result).isTrue();
        }

        @DisplayName("Q이면 False를 반환한다")
        @Test
        public void When_RetryCommandIsQ_Expect_False() {
            boolean result = bridgeGame.retry(new RetryCommand("Q"));
            assertThat(result).isFalse();
        }
    }

    @DisplayName("Final라운드가 맞다면")
    @Nested
    class IsFinalRound {

        @DisplayName("gameClear는 true를 반환한다.")
        @Test
        public void When_IsFinalRound_Expect_True() {
            boolean gameClear = bridgeGame.isGameClear();
            assertThat(gameClear).isTrue();
        }

        @DisplayName("gameResult는 true를 가지고 있다.")
        @Test
        public void When_IsFinalRound_Expect_GameResultContainTrue() {
            GameResult gameResult = bridgeGame.closeGame();
            assertThat(gameResult.isGameClear()).isTrue();
        }
    }

    @DisplayName("Final라운드가 아니라면")
    @Nested
    class IsNotFinalRound {

        @BeforeEach
        private void init() {
            bridgeGame = BridgeGame.of(
                    new MockBridgeGameRepository(),
                    new MockBridgeSizeFalseMaker(),
                    new BridgeSize(3)
            );
        }

        @DisplayName("gameClear는 false를 반환한다.")
        @Test
        public void When_IsNotFinalRound_Expect_False() {
            boolean gameClear = bridgeGame.isGameClear();
            assertThat(gameClear).isFalse();
        }

        @DisplayName("gameResult는 false를 가지고 있다.")
        @Test
        public void When_IsNotFinalRound_Expect_GameResultContainFalse() {
            GameResult gameResult = bridgeGame.closeGame();
            assertThat(gameResult.isGameClear()).isFalse();
        }
    }

    class MockBridgeGameRepository extends BridgeGameRepository {

        @Override
        public int getRound() {
            return 3;
        }

        @Override
        public void retry() {
        }
    }

    class MockBridgeMaker extends BridgeMaker {
        public MockBridgeMaker() {
            super(null);
        }
        @Override
        public List<String> makeBridge(int size) {
            return List.of("U", "D", "U");
        }
    }

    class MockBridgeSizeFalseMaker extends BridgeMaker {
        public MockBridgeSizeFalseMaker() {
            super(null);
        }
        @Override
        public List<String> makeBridge(int size) {
            return List.of("U", "D", "U","U");
        }
    }
}