package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadGameCommandTest extends NsTest {
    @DisplayName("입력이 R가 아니면 예외 발생.")
    @Test
    void inputNotR() {
        assertSimpleTest(() -> {
            runException("r");
            assertThat(output()).contains(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("RR");
            assertThat(output()).contains(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
        });
    }

    @DisplayName("입력이 Q가 아니면 예외 발생.")
    @Test
    void inputNotQ() {
        assertSimpleTest(() -> {
            runException("q");
            assertThat(output()).contains(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
        });

        assertSimpleTest(() -> {
            runException("QQ");
            assertThat(output()).contains(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readGameCommand();
    }
}
