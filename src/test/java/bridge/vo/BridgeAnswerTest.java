package bridge.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeAnswerTest {
    @Nested
    @DisplayName("주어진 숫자에 해당하는 BridgeAnswer 값을 문자열로 반환하는 getByNumber 메서드 테스트")
    class GetByNumberTest {
        @Test
        @DisplayName("1은 U로, 0은 D로 변환한다.")
        void givenOneOrZero_whenGettingByNumber_thenReturnsUOrD() {
            //when && then
            assertThat(BridgeAnswer.getByNumber(0)).isEqualTo("D");
            assertThat(BridgeAnswer.getByNumber(1)).isEqualTo("U");
        }

        @Test
        @DisplayName("주어진 숫자가 0이나 1 둘 다 아니면 예외가 발생한다.")
        void givenNorOneOrZero_whenGettingByNumber_thenThrowsException() {
            //when && then
            assertThatThrownBy(() -> BridgeAnswer.getByNumber(2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(BridgeAnswer.INVALID_NUMBER_MESSAGE);
        }
    }
}