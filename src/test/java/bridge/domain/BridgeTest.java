package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeTest {

    @DisplayName("입력한 숫자에 해당하는 다리가 없는 경우, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {2, 11})
    void getSymbolByExceptionTest(int number) {
        assertThatThrownBy(() -> Bridge.getBridgeSymbolBy(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 숫자에 해당하는 다리의 기호를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"0,D", "1,U"})
    void getSymbolByTest(int number, String expectedSymbol) {
        assertThat(Bridge.getBridgeSymbolBy(number))
                .isEqualTo(expectedSymbol);
    }
}
