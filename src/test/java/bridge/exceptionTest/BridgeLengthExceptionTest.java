package bridge.exceptionTest;
import bridge.exception.BridgeLengthException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class BridgeLengthExceptionTest {

    BridgeLengthException bridgeLengthException;

    @BeforeEach
    void initializeClass(){
        bridgeLengthException = new BridgeLengthException();
    }

    @DisplayName("입력이 숫자가 아니면 예외처리")
    @Test
    void validateWrongTest(){
        assertThatThrownBy(()->bridgeLengthException.validate("q"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 3보다 작으면 예외처리")
    @Test
    void validateLowerRangeTest(){
        assertThatThrownBy(()->bridgeLengthException.validate("1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 20보다 크면 에외처리")
    @Test
    void validateOverRangeTest(){
        assertThatThrownBy(()->bridgeLengthException.validate("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력이 올바를 때 정수로 반환")
    @Test
    void validateTest(){
        assertThat(bridgeLengthException.validate("4")).isEqualTo(4);
    }
}
