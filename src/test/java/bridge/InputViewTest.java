package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {
    InputView inputView = new InputView();

    @Test
    void enterBridgeSizeByInvalidateValue() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 숫자가 아닙니다.");
                }
        );
    }

    @Override
    protected void runMain() { Application.main(new String[]{}); }
}
