package Util;

import bridge.Util.InputValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputTest {

    @DisplayName("다리 생성 input의 타입 오류")
    @Test
    void 다리_생성_타입_예외(){
        assertThatThrownBy(() -> InputValidator.validateBridgeInput("jp"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 input의 크기 오류")
    @Test
    void 다리_생성_크기_예외(){
        assertThatThrownBy(() -> InputValidator.validateBridgeInput("25"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
