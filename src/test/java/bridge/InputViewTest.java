package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {

    @Test
    void enterBridgeSizeByInvalidValue() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("a"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 숫자가 아닙니다.");
                }
        );
    }

    @Test
    void enterBridgeSizeByInvalidRange() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("21"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("[ERROR] 3부터 20 사이의 숫자가 아닙니다.");
        });
    }

    @Override
    protected void runMain() { Application.main(new String[]{}); }
}
