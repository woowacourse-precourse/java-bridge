package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class GameRetryCheckerTest {

    GameRetryChecker retryChecker;

    @BeforeEach
    public void init() {
        retryChecker = new GameRetryChecker();
    }

    @DisplayName("허용된 입력시 대응하는 응답값 생성")
    @ParameterizedTest
    @MethodSource("parameterProviderForAllowInput")
    public void createAllowInput(String input, boolean expect) {
        assertThat(retryChecker.isRetry(input)).isEqualTo(expect);
    }

    private static Stream<Arguments> parameterProviderForAllowInput() {
        return Stream.of(
                Arguments.arguments("R", true)
                , Arguments.arguments("Q", false)
        );
    }

    @DisplayName("허용되지 않은 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"RD", "QQ", "2"})
    public void createDeniedInput(String input) {
        assertThatThrownBy(() -> retryChecker.isRetry(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}