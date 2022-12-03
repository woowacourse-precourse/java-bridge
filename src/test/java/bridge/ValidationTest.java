package bridge;

import bridge.validation.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationTest {

    Validation validation = new Validation();

    @Test
    @DisplayName("다리사이즈가 범위 밖이면 에러를 내뿜는지 테스트")
    void bridgeSizeIsInRangeTest() {
        assertThatThrownBy(() -> validation.bridgeSizeIsInRange(1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validation.bridgeSizeIsInRange(21))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("U, D가 아닌 문자 입력시 에러를 내뿜는지 테스트")
    void moveUOrD() {
        assertThatThrownBy(() -> validation.moveIsUOrD("hvyuhgh"))
                .isInstanceOf(IllegalArgumentException.class);

        validation.moveIsUOrD("U");
        validation.moveIsUOrD("D");
    }

    @Test
    @DisplayName("Q, R 이외의 문자 입력시 에러를 내뿜는지 테스트")
    void quitOrRestart() {
        assertThatThrownBy(() -> validation.quitOrRestart("D"))
                .isInstanceOf(IllegalArgumentException.class);

        validation.quitOrRestart("Q");
        validation.quitOrRestart("R");
    }
}
