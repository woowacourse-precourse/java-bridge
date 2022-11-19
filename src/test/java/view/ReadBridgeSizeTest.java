package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadBridgeSizeTest extends NsTest {

    @DisplayName("입력의 길이가 1~2 사이가 아니면 예외 발생.")
    @Test
    void inputOutOfLengthNumber() {
        assertSimpleTest(() -> {
            runException("123");
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("1");
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });
    }

    @DisplayName("입력의 변환값이 3~20 사이가 아니면 예외 발생.")
    @Test
    void inputOutOfRangeNumber() {
        assertSimpleTest(() -> {
            runException("2");
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(IllegalArgument.NOT_BRIDGE_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readBridgeSize();
    }
}
