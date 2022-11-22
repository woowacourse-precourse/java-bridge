package bridge.validation;

import static bridge.validation.CommonValidator.checkCommand;
import static bridge.validation.CommonValidator.checkMoving;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommonValidatorTest {

    @DisplayName("게임 명령이 R 또는 Q가 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"r", "q", "a", "b", "A", "B", "RR", "QQ"})
    @ParameterizedTest
    void makeWrongCommand(String command) {
        assertThrows(IllegalArgumentException.class,
                () -> checkCommand(command));
    }

    @DisplayName("이동할 칸이 U 또는 D이 아닐 경우 예외 발생 확인")
    @CsvSource(value = {"u", "d", "a", "b", "A", "B", "UU", "DD"})
    @ParameterizedTest
    void makeWrongMoving(String moving) {
        assertThrows(IllegalArgumentException.class,
                () -> checkMoving(moving));
    }
}
