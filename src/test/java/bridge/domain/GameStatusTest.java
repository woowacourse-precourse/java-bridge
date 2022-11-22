package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameStatusTest {
    @DisplayName("현재 사용자가 다리만 건넜으면 진행중, 끝까지도 도달했다면 성공이다.")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 이동가능_여부에_따른_상태값_계산(boolean isCrossed, boolean isReached, GameStatus expected) {
        assertThat(GameStatus.findByStatus(isCrossed, isReached)).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(true, true, GameStatus.SUCCESS),
                arguments(true, false, GameStatus.PLAYING),
                arguments(false, true, GameStatus.FAILED),
                arguments(false, false, GameStatus.FAILED)
        );
    }
}