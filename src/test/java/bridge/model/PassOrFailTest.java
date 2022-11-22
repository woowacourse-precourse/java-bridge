package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class PassOrFailTest {

    @Nested
    @DisplayName("생성자 유효성 테스트")
    class DescribeConstructValidate {

        @ParameterizedTest
        @NullSource
        @DisplayName("null인 UpOrDwon 인자를 받을 경우")
        void receiveOutRangeSize(UpOrDown upOrDown) {
            //then
            Assertions.assertThatThrownBy(() -> new PassOrFail(true, upOrDown))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("유효한 인자를 받을 경우 정상적인 객체 반환")
        void receiveValidString() {
            //given
            UpOrDown upOrDown = new UpOrDown("U");

            //when
            PassOrFail actual = new PassOrFail(true, upOrDown);

            //then
            Assertions.assertThat(actual.getClass()).isEqualTo(PassOrFail.class);
        }
    }
}