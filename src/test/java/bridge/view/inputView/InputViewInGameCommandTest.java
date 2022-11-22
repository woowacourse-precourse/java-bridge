package bridge.view.inputView;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import bridge.view.InputViewImpl;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("게임 진행 명령어 입력을 받을 때에는")
public class InputViewInGameCommandTest {

    private final InputView inputView = new InputViewImpl();
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("U, D 중 하나를 입력 받는다.")
    @ParameterizedTest
    @MethodSource("PassingTestParams")
    void PassingTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView.readInGameCommand();
    }

    private static Stream<String> PassingTestParams() {
        return Stream.of(
                "U",
                "D"
        );
    }

    @DisplayName("U, D 제외 다른 것은 입력 받을 수 없다.")
    @ParameterizedTest
    @MethodSource("commandFailTestParams")
    void commandFailTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEAD);
    }

    private static Stream<String> commandFailTestParams() {
        return Stream.of(
                "u",
                "DD",
                "UP",
                "Down",
                "위",
                "1"
        );
    }
}
