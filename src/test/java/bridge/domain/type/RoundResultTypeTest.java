package bridge.domain.type;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RoundResultTypeTest {
    static Stream<Arguments> getResourceForRoundResult() {
        return Stream.of(
                Arguments.of(MoveResultType.FAIL, false, RoundResultType.FAIL),
                Arguments.of(MoveResultType.SUCCESS, false, RoundResultType.PLAYING),
                Arguments.of(MoveResultType.SUCCESS, true, RoundResultType.CLEAR)
        );
    }

    @ParameterizedTest
    @MethodSource("getResourceForRoundResult")
    @DisplayName("올바른 RoundResult를 가져오는지 검사")
    void TestGetRoundResult(MoveResultType moveResultType, boolean isClear, RoundResultType roundResultType){
        assertThat(RoundResultType.of(moveResultType, isClear)).isEqualTo(roundResultType);
    }
}
