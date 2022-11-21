package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class BridgeGameTest {

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    @DisplayName("getMovingResult 메소드 테스트")
    class GetMovingResult {
        @ParameterizedTest
        @MethodSource("parameterProvider")
        void 움직임에_따라_올바른_결과를_반환하는지_테스트(List<String> moveInfo, List<Integer> randomValues) {
            assertRandomNumberInRangeTest(() -> {
                BridgeGame bridgeGame = new BridgeGame();
                bridgeGame.initAnswerBridge(moveInfo.size());
                GameStatus gameStatus = null;

                for (String move : moveInfo) {
                    gameStatus = bridgeGame.getMovingResult(move);
                }
                System.out.println(gameStatus.getGameHistory());
                assertThat(gameStatus.isClear()).isTrue();
            }, 1, randomValues.toArray(new Integer[0]));
        }

        private Stream<Arguments> parameterProvider() {
            return Stream.of(
                    Arguments.of(List.of("U"), List.of()),
                    Arguments.of(List.of("U", "D"), List.of(0)),
                    Arguments.of(List.of("U", "D"), List.of(0)),
                    Arguments.of(List.of("U", "D", "D"), List.of(0, 0)),
                    Arguments.of(List.of("U", "D", "D", "U", "D"), List.of(0, 0, 1, 0))
            );
        }
    }
}