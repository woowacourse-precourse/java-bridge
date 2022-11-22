package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class OutputViewTest {
    @ParameterizedTest
    @DisplayName("결과 리스트를 문자열로 변환한다.")
    @MethodSource("provideParametersForTransform")
    void transformStringListToMapString(List<String> mapResult, String result) {
        assertThat(new OutputView().transformToString(mapResult)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForTransform() {
        return Stream.of(
                Arguments.of(List.of("O"), "[ O ]"),
                Arguments.of(List.of("X", "O"), "[ X | O ]"),
                Arguments.of(List.of("O", "O", "O"), "[ O | O | O ]"),
                Arguments.of(List.of(" ", " ", "X"), "[   |   | X ]")
        );
    }

    @ParameterizedTest
    @DisplayName("성공 여부를 문자열로 변환한다.")
    @MethodSource("provideParametersForResult")
    void transformResultToString(boolean reachedEnd, String result) {
        assertThat(new OutputView().getResultString(reachedEnd)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForResult() {
        return Stream.of(
                Arguments.of(true, "게임 성공 여부: 성공"),
                Arguments.of(false, "게임 성공 여부: 실패")
        );
    }

    @ParameterizedTest
    @DisplayName("시도 횟수를 문자열로 변환한다.")
    @MethodSource("provideParametersForAttempts")
    void transformAttemptsToString(int attempts, String result) {
        assertThat(new OutputView().getAttemptString(attempts)).isEqualTo(result);
    }
    private static Stream<Arguments> provideParametersForAttempts() {
        return Stream.of(
                Arguments.of(1, "총 시도한 횟수: 1"),
                Arguments.of(13, "총 시도한 횟수: 13")
        );
    }
}
