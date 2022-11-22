package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadBridgeSizeTest extends NsTest {
    @DisplayName("입력의 길이가 1~2 사이에 포함되지 않으면 예외 발생.")
    @ValueSource(strings = {"123", "109237381", "\n"})
    @ParameterizedTest
    void inputOutOfLengthNumber(String numberInput) {
        assertSimpleTest(() -> {
            runException(numberInput);
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });
    }

    @DisplayName("입력의 변환값이 3~20 사이의 수가 아니면 예외 발생.")
    @ValueSource(strings = {"2", "21", "0", "45"})
    @ParameterizedTest
    void inputOutOfRangeNumber(String numberInput) {
        assertSimpleTest(() -> {
            runException(numberInput);
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readBridgeSize();
    }
}
