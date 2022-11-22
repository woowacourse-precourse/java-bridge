package bridge.view.inputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import bridge.view.InputViewImpl;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("다리 크기 입력을 받을 때에는")
public class InputViewFailMenuCommandTest {

    private final InputView inputView = new InputViewImpl();
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("R, Q 중 하나를 입력 받는다.")
    @ParameterizedTest
    @MethodSource("PassingTestParams")
    void PassingTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView.readFailMenuCommand();
    }

    private static Stream<String> PassingTestParams() {
        return Stream.of(
                "R",
                "Q"
        );
    }

    @DisplayName("R, Q 제외 다른 것을 입력 받으면, 실패해야 한다.")
    @ParameterizedTest
    @MethodSource("commandFailTestParams")
    void commandFailTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readFailMenuCommand)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEAD);
    }

    private static Stream<String> commandFailTestParams() {
        return Stream.of(
                "r",
                "QQ",
                "QUIT",
                "Restart",
                "재시작",
                "1"
        );
    }
}
