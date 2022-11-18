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
}
