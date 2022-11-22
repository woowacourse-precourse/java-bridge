package bridge.vo.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StepTest {

    @Nested
    @DisplayName("주어진 숫자에 해당하는 BridgeAnswer 값을 문자열로 반환하는 getByNumber 메서드 테스트")
    class GetByNumberTest {
        @Test
        @DisplayName("1은 U로, 0은 D로 변환한다.")
        void givenOneOrZero_whenGettingByNumber_thenReturnsUOrD() {
            //when && then
            assertThat(Step.getByNumber(0)).isEqualTo(Step.D.toString());
            assertThat(Step.getByNumber(1)).isEqualTo(Step.U.toString());
        }

        @Test
        @DisplayName("주어진 숫자가 0이나 1 둘 다 아니면 예외가 발생한다.")
        void givenNorOneOrZero_whenGettingByNumber_thenThrowsException() {
            //when && then
            assertThatThrownBy(() -> Step.getByNumber(2))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Step.INVALID_VALUE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("주어진 문자열 해당하는 BridgeAnswer 값을 찾아내는 getByValue 메서드")
    class GetByValueTest {
        @Test
        @DisplayName("주어진 문자열에 해당하는 Command 객체를 반환한다.")
        void givenOneOrZero_whenGettingByNumber_thenReturnsUOrD() {
            //when && then
            assertThat(Step.getByValue("U")).isEqualTo(Step.U);
            assertThat(Step.getByValue("D")).isEqualTo(Step.D);
        }

        @Test
        @DisplayName("주어진 숫자가 0이나 1 둘 다 아니면 예외가 발생한다.")
        void givenNorOneOrZero_whenGettingByNumber_thenThrowsException() {
            //when && then
            assertThatThrownBy(() -> Step.getByValue("Z"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Step.INVALID_VALUE_MESSAGE);
        }
    }

    @Nested
    @DisplayName("주어진 문자열 배열을 Step 배열로 바꾸는 from 메서드")
    class FromTest {
        @Test
        @DisplayName("U와 D로 이루어진 문자열 배열이 주어지면 Step 배열로 바꾼다.")
        void givenUAndDs_whenRunningFrom_thenReturnsSteps() {
            //given
            List<String> given = List.of("U", "D", "U", "D");

            //when
            List<Step> steps = Step.from(given);

            //then
            assertThat(steps).containsExactly(Step.U, Step.D, Step.U, Step.D);
        }

        @Test
        @DisplayName("U 또는 D가 아닌 문자열이 배열에 있으면 예외가 발생한다.")
        void givenNotUNorD_whenRunningFrom_thenThrowsException() {
            //given
            List<String> given = List.of("U", "D", "R", "D");

            //when && then
            assertThatThrownBy(() -> Step.from(given))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Step.INVALID_VALUE_MESSAGE);
        }
    }
}