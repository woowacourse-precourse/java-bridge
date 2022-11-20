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
                .hasMessage("[ERROR] 다리의 길이는 정수여야 합니다.");
    }
    @Test
    @DisplayName("입력한 다리 길이가 3~20사이 일때 true 반환하는지 확인")
    void trueCheckBridgeRange(){
        assertThat(Validator.checkRange("13")).isTrue();
    }
    @Test
    @DisplayName("입력한 다리 길이가 3~20사이 일때 true 반환하는지 확인")
    void falseCheckBridgeRange(){
        assertThatThrownBy(()->Validator.checkRange("21"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 다리의 길이는 3부터 20 사이의 숫자여야 합니다.");
    }
}