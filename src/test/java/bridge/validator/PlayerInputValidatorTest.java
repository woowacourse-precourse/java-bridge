package bridge.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PlayerInputValidatorTest {

    PlayerInputValidator playerInputValidator;

    @BeforeEach
    void init() {
        playerInputValidator = new PlayerInputValidator();
    }

    @ParameterizedTest
    @CsvSource(value = {"U", "P"})
    @DisplayName("사용자가 움직이기 위해서 U, D 중 하나를 입력할 경우 아무것도 반환하지 않는다.")
    void testCanMove_success(String input) throws Exception {
        //when & then
        playerInputValidator.canMove(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "b", "김현우", "12"})
    @DisplayName("사용자가 움직이기 위해서 U, D를 입력하지 않을 경우 IllegalArgumentException 반환합니다.")
    void testCanMove_IllegalArgumentException(String input) throws Exception {
        //when & then
        assertThrows(IllegalArgumentException.class,
                     () -> playerInputValidator.canMove(input));
    }

}