package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RetryOrQuitTest {

    @Nested
    @DisplayName("생성자 유효성 테스트")
    class DescribeConstructValidate {

        @ParameterizedTest
        @ValueSource(strings = {"A", "B"})
        @DisplayName("인자가 R혹은 Q가 아닐경우 IllegalArgumentException 반환")
        void receiveOutRangeSize(String userInput) {
            //then
            Assertions.assertThatThrownBy(() -> new RetryOrQuit(userInput))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"Q", "R"})
        @DisplayName("Q 혹은 R을 인자로 받을 경우 정상적인 객체 반환")
        void receiveValidString(String userInput) {
            //when
            RetryOrQuit actual = new RetryOrQuit(userInput);

            //then
            Assertions.assertThat(actual.getClass()).isEqualTo(RetryOrQuit.class);
        }
    }
}