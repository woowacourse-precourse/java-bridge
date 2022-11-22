package bridge.vo.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CommandTest {

    @Nested
    @DisplayName("주어진 문자열에 해당하는 Command 객체를 반환하는 getByValue 메서드")
    class GetByValueTest {
        @ParameterizedTest(name = "입력값 -> {0}")
        @MethodSource("bridge.vo.enums.CommandTest#sourceOfValueAndCommand")
        @DisplayName("주어진 값에 해당하는 Command 객체를 반환한다.")
        void givenValue_whenGettingByValue_thenReturnsCommand(String value, Command command) {
            //when
            Command findCommand = Command.getByValue(value);
            //then
            assertThat(findCommand).isEqualTo(command);
        }

        @Test
        @DisplayName("R 또는 Q 어느 쪽에도 해당하지 않는 입력값이라면 예외가 발생한다.")
        void givenInvalidValue_whenGettingByValue_thenThrowsException() {
            //when && then
            assertThatThrownBy(() -> Command.getByValue("Z"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(Command.INVALID_VALUE_MESSAGE);
        }
    }

    private static Stream<Arguments> sourceOfValueAndCommand() {
        return Stream.of(
                Arguments.of("R", Command.R),
                Arguments.of("Q", Command.Q)
        );
    }

    @Nested
    @DisplayName("호출하는 Command 가 재시도를 뜻하는 객체인지 확인하는 isRetrying 메서드")
    class IsRetryingTest {
        @Test
        @DisplayName("해당 Command 의 상태가 R 이라면, 재시도를 뜻하는 Command 이다.")
        void givenRCommand_whenCallingIsRetrying_thenReturnsTrue() {
            //given
            Command command = Command.R;

            //when && then
            assertTrue(command.isRetrying());
        }
    }
}