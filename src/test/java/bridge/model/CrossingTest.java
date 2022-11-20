package bridge.model;

import java.util.ArrayList;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

class CrossingTest {

    @Nested
    @DisplayName("savePassOrFail 메서드는")
    class DescribeSavePassOrFail {

        @ParameterizedTest
        @NullSource
        @DisplayName("null을 인자로 받을경우 IllegalArgumentException을 반환한다.")
        void throwIllegalArgumentException(PassOrFail nullArgument) {
            //given
            Crossing crossing = new Crossing(new ArrayList<>());

            //then
            Assertions.assertThatThrownBy(() -> crossing.savePassOrFail(nullArgument))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("인자로 받은 PassOrFail 객체를 history리스트에 저장한다.")
        void returnFalseWhenFailCross() {
            //given
            Crossing crossing = new Crossing(new ArrayList<>());
            PassOrFail passOrFail = new PassOrFail(true);
            int expectedHistorySize = 1;

            //when
            crossing.savePassOrFail(passOrFail);

            //then
            Assertions.assertThat(crossing.getNextStep()).isEqualTo(expectedHistorySize);
        }
    }

    @Nested
    @DisplayName("isPass 메서드는")
    class DescribeIsPass {

        @Test
        @DisplayName("횡단에 성공했을 경우 true를 반환한다.")
        void returnTrueWhenSuccessCross() {
            //given
            Crossing crossing = new Crossing(new ArrayList<>());
            crossing.savePassOrFail(new PassOrFail(true));
            crossing.savePassOrFail(new PassOrFail(true));

            //when
            boolean expected = true;
            boolean actual = crossing.isPass();

            //then
            Assertions.assertThat(actual).isEqualTo(expected);
        }

        @Test
        @DisplayName("횡단에 실패했을 경우 false를 반환한다.")
        void returnFalseWhenFailCross() {
            //given
            Crossing crossing = new Crossing(new ArrayList<>());
            crossing.savePassOrFail(new PassOrFail(true));
            crossing.savePassOrFail(new PassOrFail(false));

            //when
            boolean expected = false;
            boolean actual = crossing.isPass();

            //then
            Assertions.assertThat(actual).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("getNextStep 메서드는")
    class DescribeGetNextStep {

        @Test
        @DisplayName("history의 길이를 반환한다.")
        void returnHistorySize() {
            //given
            Crossing crossing = new Crossing(new ArrayList<>());
            crossing.savePassOrFail(new PassOrFail(true));
            int expected = 1;

            //when
            int actual = crossing.getNextStep();

            //then
            Assertions.assertThat(actual).isEqualTo(expected);
        }
    }
}