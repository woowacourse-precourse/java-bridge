package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.utils.ValidateUtils;

public class ValidateUtilsTest {

    @DisplayName("정수값이 아닌 값이 들어오면 예외가 발생한다.")
    @Test
    void caseBridgeSizeInputNotNumber(){
        assertThatThrownBy(()->ValidateUtils.isCorrectRangeNumbers("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3~20 사이의 정수값이 아니면 예외가 발생한다.")
    @Test
    void caseBridgeSizeInputOver(){
        assertThatThrownBy(()->ValidateUtils.isCorrectRangeNumbers("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 또는 D 아닌 값을 입력하면 익셉션 발생")
    @Test
    void caseBridgeMoveInvalidInput(){
        assertThatThrownBy(()->ValidateUtils.isCorrectMoveValue("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
