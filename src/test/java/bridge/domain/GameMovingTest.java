package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameMovingTest {

    @Nested
    @DisplayName("getMessageFromNumber 메소드 테스트")
    class GetMessageFromNumber {
        @ParameterizedTest
        @CsvSource(value = {"0, D", "1, U"})
        void 숫자를_입력받으면_매핑된_메세지를_잘_반환하는지_테스트(int number, String expected) {
            assertThat(GameMoving.getMovingFromNumber(number)).isEqualTo(expected);
        }
    }
}