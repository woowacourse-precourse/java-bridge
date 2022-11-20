package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class StepResultTest {

    @DisplayName("움직임 방향과, 통과 유무에 따라 StepResult가 생성된다.")
    @ParameterizedTest
    @MethodSource("generateData")
    void createSuccessAndFailMovingResult(String moving, boolean passed, String resultMessage) {
        // given
        StepResult stepResult = StepResult.getStepResult(moving, passed);

        // when, then
        assertThat(stepResult.getDirection()).isEqualTo(moving);
        assertThat(stepResult.getResult()).isEqualTo(resultMessage);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of("U", true, "O"),
                Arguments.of("D", true, "O"),
                Arguments.of("U", false, "X"),
                Arguments.of("D", false, "X")
        );
    }

    @DisplayName("잘못된 움직임의 방향이 들어오는 경우 NO_RESULT가 반환된다")
    @Test
    void createStepResultWithWrongMoving() {
        // given
        String moving = "A";

        // when
        StepResult stepResult = StepResult.getStepResult(moving, false);

        // then
        assertThat(stepResult).isEqualTo(StepResult.NO_RESULT);
    }
}