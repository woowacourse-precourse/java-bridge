package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadMovingTest extends NsTest {
    @DisplayName("입력이 U가 아니면 예외 발생.")
    @Test
    void inputNotU() {
        assertSimpleTest(() -> {
            runException("u");
            assertThat(output()).contains(IllegalArgument.NOT_MOVING_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("UU");
            assertThat(output()).contains(IllegalArgument.NOT_MOVING_INPUT.getMessage());
        });
    }

    @DisplayName("입력이 D가 아니면 예외 발생.")
    @Test
    void inputNotD() {
        assertSimpleTest(() -> {
            runException("d");
            assertThat(output()).contains(IllegalArgument.NOT_MOVING_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("DD");
            assertThat(output()).contains(IllegalArgument.NOT_MOVING_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readMoving();
    }
}
