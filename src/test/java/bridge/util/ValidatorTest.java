package bridge.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ValidatorTest {
    @Test
    @DisplayName("입력이 정수일 때 true를 반환하는지 확인")
    void isDigit(){
        assertThat(Validator.isDigit("12")).isTrue();
    }
    @Test
    @DisplayName("입력이 정수가 아닌 경우 예외처리 확인")
    void isNotDigit(){
        assertThatThrownBy(()->Validator.isDigit("j1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 정수이어야 합니다.");
    }

}