package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("입력을 받을 때 입력의 길이가 9자리를 초과하면 예외가 발생한다")
    void receiveInputByOver9Length() {
        assertSimpleTest(() -> {
            runException("123456789");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 숫자가 아니면 예외가 발생한다.")
    void receiveBridgeLengthByNotNumber() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 길이가 3 미만이면 예외가 발생한다.")
    void receiveBridgeLengthByUnder3() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 길이가 20 초과이면 예외가 발생한다.")
    void receiveBridgeLengthByOver20() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}