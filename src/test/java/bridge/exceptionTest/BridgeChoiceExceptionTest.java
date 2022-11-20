package bridge.exceptionTest;
import bridge.exception.BridgeChoiceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class BridgeChoiceExceptionTest {

    BridgeChoiceException bridgeChoiceException;

    @BeforeEach
    void initializeClass(){
        bridgeChoiceException = new BridgeChoiceException();
    }

    @DisplayName("입력이 U, D가 아니면 예외처리")
    @Test
    void validateNotUNorDTest(){
        assertThatThrownBy(()->bridgeChoiceException.validate("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 U면 그대로 반환")
    @Test
    void validateUTest(){
        assertThat(bridgeChoiceException.validate("U")).isEqualTo("U");
    }

    @DisplayName("입력이 D면 그대로 반환")
    @Test
    void validateDTest(){
        assertThat(bridgeChoiceException.validate("D")).isEqualTo("D");
    }
}
