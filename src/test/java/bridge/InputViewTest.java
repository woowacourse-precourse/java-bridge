package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private static final String ERROR_MESSAGE = "[ERROR]";

    private final InputView inputView = new InputView();

    @DisplayName("다리길이가 정상인 경우")
    @Test
    void goodBridgeSize() {
        int size = inputView.validateSize("3");
        assertThat(size).isEqualTo(3);
    }

    @DisplayName("다리길이가 숫자가 아닌 경우")
    @Test
    void wrongTypeBridgeSize() {
        assertThatThrownBy(() -> inputView.validateSize("A"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리길이가 3~20 사이가 아닌 경우")
    @Test
    void wrongRangeBridgeSize() {
        assertThatThrownBy(() -> inputView.validateSize("1"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.validateSize("21"))
                .isInstanceOf(IllegalArgumentException.class);
    }



}
