package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeSizeTest {

    @Nested
    @DisplayName("생성자 유효성 테스트")
    class DescribeConstructValidate {

        @ParameterizedTest
        @ValueSource(strings = {"111", "aaaaaa"})
        @DisplayName("인자가 2자리수를 넘는 문자열일 경우 IllegalArgumentException 반환")
        void receiveLongSizeString(String userInputSize) {
            //then
            Assertions.assertThatThrownBy(() -> new BridgeSize(userInputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"1a", "a", "ab"})
        @DisplayName("인자가 숫자가 아닌 문자일 경우 IllegalArgumentException 반환")
        void receiveNotDigitString(String userInputSize) {
            //then
            Assertions.assertThatThrownBy(() -> new BridgeSize(userInputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"2", "21"})
        @DisplayName("인자가 3보다 작거나 20보다 클경우 IllegalArgumentException 반환")
        void receiveOutRangeSize(String userInputSize) {
            //then
            Assertions.assertThatThrownBy(() -> new BridgeSize(userInputSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("3 ~ 20 사이의 숫자 문자열을 인자로 받을 경우 정상적인 객체 반환")
        void receiveValidString() {
            //given
            String validString = "5";

            //when
            BridgeSize actual = new BridgeSize(validString);

            //then
            Assertions.assertThat(actual.getClass()).isEqualTo(BridgeSize.class);
        }
    }
}