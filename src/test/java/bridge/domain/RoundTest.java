package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RoundTest {

    @DisplayName("플레이어가 이동할 칸과 다리의 건널 수 있는 칸을 비교한다.")
    @ParameterizedTest
    @MethodSource("provideRounds")
    void compare(Round round, RoundResult expected) {
        RoundResult actual = round.getResult();
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRounds() {
        return Stream.of(
                Arguments.of(Named.of("플레이어 U, 다리 U", new Round("U", "U")), Named.of("성공", RoundResult.SUCCESS)),
                Arguments.of(Named.of("플레이어 U, 다리 D", new Round("U", "D")), Named.of("실패", RoundResult.FAILURE)),
                Arguments.of(Named.of("플레이어 D, 다리 U", new Round("D", "U")), Named.of("실패", RoundResult.FAILURE)),
                Arguments.of(Named.of("플레이어 D, 다리 D",new Round("D", "D")), Named.of("성공", RoundResult.SUCCESS))
        );
    }
}