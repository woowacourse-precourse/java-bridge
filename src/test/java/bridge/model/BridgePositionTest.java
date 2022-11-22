package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
}