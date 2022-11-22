package bridge;

import bridge.domain.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
    private InputValidator inputValidator;
    private static final String ERROR_MESSAGE = "[ERROR]";

    @BeforeEach
    void 생성자(){
        inputValidator = new InputValidator();
    }

    @Test
    void 숫자_예외테스트(){
        assertThatThrownBy(()-> inputValidator.returnNum("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE, "숫자로만 ");
    }

    @Test
    void 범위_예외테스트(){
        assertThatThrownBy(()->inputValidator.returnNum("35"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE, "3부터 20 사이");
    }

    @Test
    void upAndDown_Test(){
        assertThatThrownBy(()->inputValidator.checkUpDown("T"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE, "U 또는 D");
    }

    @Test
    void restartTest(){
        assertThatThrownBy(()->inputValidator.checkRetry("U"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE, "시작은 R, 종료는 Q");
    }

}
