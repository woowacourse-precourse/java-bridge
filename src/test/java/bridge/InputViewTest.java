package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    @DisplayName("다리 길이가 숫자가 아닐 때 예외 발생")
    @Test
    void bridgeSizeIsNotNumber() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateBridgeSize("l"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3 이상 20 이하가 아닐 때 예외 발생")
    @Test
    void bridgeSizeOutOfRange() {
        InputView input = new InputView();
        assertThatThrownBy(() -> input.validateBridgeSize("25"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

