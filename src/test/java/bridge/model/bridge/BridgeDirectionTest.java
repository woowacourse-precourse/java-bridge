package bridge.model.bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.util.ExceptionMessage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeDirectionTest {

    @Nested
    class invalidInputTest {

        @DisplayName("1,0이 아닌 값은 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(ints = {2, 3, 4, -1})
        void 비정상_입력(int input) {
            assertThatThrownBy(() -> BridgeDirection.from(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NO_BRIDGE_DIRECTION_NUMBER.getMessage());
        }

        @DisplayName("U,D 외의 값은 예외 처리한다.")
        @ParameterizedTest
        @ValueSource(strings = {"u", "d", "12", "sdjksdk"})
        void 비정상_입력(String input) {
            assertThatThrownBy(() -> BridgeDirection.from(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.NO_BRIDGE_DIRECTION_SIGN.getMessage());
        }

    }

    @Nested
    class validInputTest {
        @ParameterizedTest
        @ValueSource(strings = {"U", "D"})
        void 정상_입력(String input) {
            assertThatCode(() -> BridgeDirection.from(input))
                    .doesNotThrowAnyException();
        }

        @Test
        void 입력값_체크() {
            Assertions.assertEquals(BridgeDirection.UP, BridgeDirection.from("U"));
            Assertions.assertEquals(BridgeDirection.DOWN, BridgeDirection.from("D"));
        }
    }

}