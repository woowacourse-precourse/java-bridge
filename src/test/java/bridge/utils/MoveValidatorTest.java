package bridge.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoveValidatorTest {

    @DisplayName("유저가 입력한 이동값이 U나 D가 아니면 예외 처리 테스트")
    @ValueSource(strings={"1","as","A"})
    @ParameterizedTest
    void checkMove1(String input) {
        IllegalArgumentException exception=assertThrows(IllegalArgumentException.class,
                ()->MoveValidator.checkMove(input));
        assertThat(exception.getMessage()).isEqualTo("[ERROR] U나 D를 입력해야 합니다.");
    }
}