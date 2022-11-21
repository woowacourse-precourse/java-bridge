package bridge.model;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeTest {

    @Nested
    @TestInstance(Lifecycle.PER_CLASS)
    @DisplayName("isCross 메서드는")
    class DescribeIsCross {

        private Stream<Arguments> provideNotValidArguments() {
            return Stream.of(
                    Arguments.of(0, null),
                    Arguments.of(-1, new UpOrDown("U")),
                    Arguments.of(100, new UpOrDown("U"))
            );
        }

        @ParameterizedTest
        @MethodSource("provideNotValidArguments")
        @DisplayName("인자로 null인 UpOrDown 혹은 bridge 필드에 존재하지 않는 index를 인자로 받으면 IllegalArgumentException 반환")
        void throwIllegalArgumentExceptionWhenNotValidArgument(int index, UpOrDown upOrDown) {
            //given
            Bridge bridge = new Bridge(List.of(new UpOrDown("U")));

            //then
            Assertions.assertThatThrownBy(() -> bridge.isCross(index, upOrDown))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("인자로 받은 UpOrDown과 bridge의 값이 다르면 false를 반환")
        void returnFalseWhenNotEqualValue() {
            //given
            int index = 0;
            UpOrDown upOrDown = new UpOrDown("D");
            Bridge bridge = new Bridge(List.of(new UpOrDown("U")));

            //when
            boolean actual = bridge.isCross(index, upOrDown);

            //then
            Assertions.assertThat(actual).isFalse();
        }

        @Test
        @DisplayName("인자로 받은 UpOrDown과 bridge의 값이 같으면 true를 반환")
        void returnTrueWhenNotEqualValue() {
            //given
            int index = 0;
            UpOrDown upOrDown = new UpOrDown("U");
            Bridge bridge = new Bridge(List.of(new UpOrDown("U")));

            //when
            boolean actual = bridge.isCross(index, upOrDown);

            //then
            Assertions.assertThat(actual).isTrue();
        }
    }
}