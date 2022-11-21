package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("GameResult 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameResultTest {
    private static Stream<Arguments> generateResult() {
        return Stream.of(
                Arguments.of(true, GameResult.SUCCESS),
                Arguments.of(false, GameResult.FAILURE)
        );
    }

    @ParameterizedTest
    @MethodSource("generateResult")
    void from_메서드는_주어진_값에_따라_결과에_해당하는_enum_을_반환합니다(final boolean input, final GameResult expected) {
        assertThat(GameResult.from(input)).isEqualTo(expected);
    }
}
