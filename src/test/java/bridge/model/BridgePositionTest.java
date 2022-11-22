package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("BridgePosition을 테스트한다.")
class BridgePositionTest {

    @Nested
    @DisplayName("반환되는 position 값을 검증한다.")
    class returnPositionTest {

        @DisplayName("0과 1를 입력해서, position을 만들면 오류 없이 성공한다.")
        @ParameterizedTest
        @CsvSource(value = {"1, U", "0, D"})
        void returnUpOrDownPositionWhenGivenZeroOrTwo(int number, String position) {
            assertThat(BridgePosition.from(number)).isEqualTo(position);
        }

        @DisplayName("0과 1이외의 값을 입력하여 position을 만들면 오류가 발생한다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 2, 3, 5, -99})
        void throwExceptionWhenGivenWrongNumber(int number) {
            assertThatThrownBy(() -> BridgePosition.from(number))
                    .isInstanceOf(IllegalStateException.class);
        }
    }

    @DisplayName("성공적으로 움직였는지 확인한다.")
    @ParameterizedTest
    @MethodSource("initSuccessMethodTest")
    void returnTrueIfContainsO(final List<String> moveResult, final boolean result) {
        assertThat(BridgePosition.isSuccess(moveResult)).isEqualTo(result);
    }

    private static Stream<Arguments> initSuccessMethodTest() {
        return Stream.of(
                Arguments.of(List.of("O", " "), true),
                Arguments.of(List.of(" ", "O"), true),
                Arguments.of(List.of("X", " "), false),
                Arguments.of(List.of(" ", "X"), false)
        );
    }


    @DisplayName("성공적으로 움직였는지 확인한다.")
    @ParameterizedTest
    @MethodSource("initCompareCommandData")
    void returnResultWhenCompareCommand(final String nextCommand, final String command, final List<String> result) {
        assertThat(BridgePosition.compare(nextCommand, command)).isEqualTo(result);
    }

    private static Stream<Arguments> initCompareCommandData() {
        return Stream.of(
                Arguments.of("U", "U", List.of("O", " ")),
                Arguments.of("U", "D", List.of(" ", "X")),
                Arguments.of("D", "D", List.of(" ", "O")),
                Arguments.of("D", "U", List.of("X", " "))
        );
    }
}