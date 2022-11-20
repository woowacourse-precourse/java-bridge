package view;

import camp.nextstep.edu.missionutils.test.NsTest;
import exception.IllegalArgument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

public class ReadGameCommandTest extends NsTest {
    @DisplayName("입력이 R이나 Q가 아니면 예외 발생.")
    @ValueSource(strings = {"dkanrjskcla","QQ","q","RR","r","U","D"})
    @ParameterizedTest
    void inputNotROrQ(String commandInput) {
        assertSimpleTest(() -> {
            runException(commandInput);
            assertThat(output()).contains(IllegalArgument.NOT_COMMAND_INPUT.getMessage());
        });
    }

    @Override
    protected void runMain() {
        InputView.readGameCommand();
    }
}
