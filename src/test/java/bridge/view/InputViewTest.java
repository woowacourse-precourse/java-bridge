package bridge.view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import bridge.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    @DisplayName("입력을 받을 때 입력의 길이가 9자리를 초과하면 예외가 발생해야 한다.")
    void receiveInputByOver9Length() {
        assertSimpleTest(() -> {
            runException("123456789");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("다리의 길이를 입력받을 때 숫자가 아니면 예외가 발생해야 한다.")
    void receiveBridgeLengthByNotNumber() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @ParameterizedTest
    @DisplayName("다리의 길이를 입력받을 때 길이가 3 미만, 20 초과이면 예외가 발생해야 한다.")
    @ValueSource(strings = {"2", "21"})
    void receiveBridgeLengthByUnder3OrOver20Size(String input) {
        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    @DisplayName("이동할 칸을 입력받을 때 U 또는 D가 아니면 예외가 발생해야 한다.")
    void receiveMovingByNotUorD() {
        assertSimpleTest(() -> {
            runException("3", "Z");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}