package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class UpOrDownTest {

    @Nested
    @DisplayName("생성자 유효성 테스트")
    class DescribeConstructValidate {

        @ParameterizedTest
        @NullSource
        @DisplayName("인자로 null을 받을경우 IllegalArgumentException 반환")
        void receiveNull(String nullSource) {
            //then
            Assertions.assertThatThrownBy(() -> new UpOrDown(nullSource))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"A", "B"})
        @DisplayName("인자로 U, D가 아닌 값을 받을 경우 IllegalArgumentException 반환")
        void receiveNotValidArgument(String wrongArgument) {
            //then
            Assertions.assertThatThrownBy(() -> new UpOrDown(wrongArgument))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        @DisplayName("인자로 U, D를 받을 경우 정상적인 객체 생성")
        void receiveValidString(String direction) {
            //when
            UpOrDown actual = new UpOrDown(direction);

            //then
            Assertions.assertThat(actual.getClass()).isEqualTo(UpOrDown.class);
        }
    }
}