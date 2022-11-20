package bridge;

import bridge.domain.utils.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ExceptionSituationTest {

    @DisplayName("다리의 길이로 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void inputBridgeSizeNotIntTest() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("notInt"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 다리의 길이가 3 미만, 20 초과이면 예외가 발생한다.")
    @Test
    void inputBridgeSizeOutOfBoundsTest() {
        assertThatThrownBy(() -> Validation.validateBridgeSize("30"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 이동할 칸 정보가 U나 D가 아닌 경우 예외가 발생한다.")
    @Test
    void inputForMoveNotUOrDTest() {
        assertThatThrownBy(() -> Validation.validateSpace("wrongInput"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부에 대한 응답이 R 또는 Q가 아닌 경우 예외가 발생한다." )
    @Test
    void inputAfterFailureNotROrQTest() {
        assertThatThrownBy(() -> Validation.validateResponseAfterFailure("wrongInput"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
