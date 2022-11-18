package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ProgressTest {
    @DisplayName("현재 사용자가 다리를 건넜고, 끝까지 도달했다면 성공이다.")
    @ParameterizedTest
    @MethodSource("parametersProvider")
    void 이동가능_여부에_따른_상태값_계산(boolean isCrossed, boolean isReached, ProgressStatus expected){
        assertThat(ProgressStatus.findByStatus(isCrossed, isReached)).isEqualTo(expected);
    }

    static Stream<Arguments> parametersProvider() {
        return Stream.of(
                arguments(true, true, ProgressStatus.SUCCESS),
                arguments(true, false, ProgressStatus.ONGOING),
                arguments(false, true, ProgressStatus.FAILED),
                arguments(false, false, ProgressStatus.FAILED)
        );
    }
}