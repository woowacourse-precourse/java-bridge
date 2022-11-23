package bridge.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MovingTypeTest {

    @Nested
    @DisplayName("숫자로 BridgeType 가져오기 로직 검증")
    class getBridgeTypeByNumNotation {

        @ParameterizedTest(name = "입력이 {0}면 가져온 BridgeType의 engNotation은 {1}")
        @CsvSource({"1,U", "0, D"})
        void 가져오기(String input, String output) {
            // given
            int numNotation = Integer.parseInt(input);
            // when
            String resultEngNotation = getResultEngNotation(numNotation);
            // then
            assertThat(resultEngNotation).isEqualTo(output);
        }

        @ParameterizedTest(name = "{0}은 유효한 옵션이 아니므로 예외 발생")
        @ValueSource(ints = {3, 4, 10, -1})
        @DisplayName("1이나 2가 아닌 입력이 들어오면 예외")
        void 예외(int input) {
            // given
            int numNotation = input;
            // when
            // then
            assertThatThrownBy(() -> getResultEngNotation(numNotation))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        private String getResultEngNotation(int numNotation) {
            MovingType result = MovingType.getMovingTypeByNumNotation(numNotation);
            return result.getEngNotation();
        }
    }

    @Nested
    @DisplayName("BridgeType에 포함된 옵션인지 확인하는 로직 검증")
    class ContainOption {

        @ParameterizedTest(name = "선택지에 없는 {0}옵션은 false값 리턴")
        @ValueSource(strings = {"X", "R", "Q", "Y"})
        void 선택지에_없는_옵션(String input) {
            // given
            String bridgeType = input;
            // when
            boolean result = MovingType.isContains(bridgeType);
            // then
            assertThat(result).isFalse();
        }

        @ParameterizedTest(name = "선택지에 있는 {0}옵션은 true 값 리턴")
        @ValueSource(strings = {"U", "D"})
        void 선택지에_있는_옵션(String input) {
            // given
            String bridgeType = input;
            // when
            boolean result = MovingType.isContains(bridgeType);
            // then
            assertThat(result).isTrue();
        }
    }
}