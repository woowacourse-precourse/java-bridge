package bridge.domain.calculator;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("입력 이동 값 계산 기능 테스트")
class BridgeCalculatorTest {

    private static final BridgeCalculator calculator = new BridgeCalculator(List.of("U", "D", "D"));

    @DisplayName("통합 유효성 검사")
    @ParameterizedTest(name = "{displayName} 입력값({index}) : Round={0} | Input={1}")
    @MethodSource("paramsForIsCrossable")
    void isCrossable(int roundValue, String inputValue, boolean correctResult) {
        assertThat(calculator.isCrossable(roundValue, inputValue)).isEqualTo(correctResult);
    }
    private static Stream<Arguments> paramsForIsCrossable() {
        return Stream.of(
                Arguments.of(2, "U", false),
                Arguments.of(0, "U", true),
                Arguments.of(1, "D", true)
        );
    }
}