package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayerInputValidatorTest {

    @ParameterizedTest
    @CsvSource(value = {"U", "P"})
    @DisplayName("사용자가 움직이기 위해서 U, D 중 하나를 입력할 경우 아무것도 반환하지 않는다.")
    void testCanMove_success(String input) throws Exception {
        //when & then
        PlayerInputValidator.canMove(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "b", "김현우", "12"})
    @DisplayName("사용자가 움직이기 위해서 U, D를 입력하지 않을 경우 IllegalArgumentException 반환합니다.")
    void testCanMove_IllegalArgumentException(String input) throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> PlayerInputValidator.canMove(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"Q", "R"})
    @DisplayName("사용자가 재시작, 종료를 위해서 Q, R 중 하나를 입력할 경우 아무것도 반환하지 않는다.")
    void testCanFinish_success(String input) throws Exception {
        //when & then
        PlayerInputValidator.canFinish(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "b", "김현우", "12"})
    @DisplayName("사용자가 재시작, 종료를 위해서 Q, R를 입력하지 않을 경우 IllegalArgumentException 반환합니다.")
    void testCanFinish_IllegalArgumentException(String input) throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> PlayerInputValidator.canFinish(input));
    }

}