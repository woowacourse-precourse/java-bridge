package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadMovingTest extends NsTest {
    @DisplayName("입력이 U나 D가 아니면 예외 발생.")
    @ValueSource(strings = {"dkanrjskcla","UU","u","DD","d","R","Q"})
    @ParameterizedTest
    void inputNotUOrD(String commandInput) {
        assertSimpleTest(() -> {
            runException(commandInput);
            assertThat(output()).contains(IllegalArgument.NOT_MOVING_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readMoving();
    }
}
