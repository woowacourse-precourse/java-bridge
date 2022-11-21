package bridge.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameCommandTest {

    @DisplayName("findBySymbol 메서드는 R 또는 Q 외의 다른 문자가 입력되면 에러가 발생한다.")
    @Nested
    class findBySymbol {
        @ValueSource(strings = {"U", "D", "O", "X"})
        @ParameterizedTest(name = "입력값={0}")
        void findBySymbolThenThrowException(String symbol) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> GameCommand.findBySymbol(symbol));
        }
    }
}
