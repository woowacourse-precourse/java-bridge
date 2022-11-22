package bridge.view.inputView;

import bridge.exception.ErrorMsg;
import bridge.utill.ConsoleTestUtil;
import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoveInputTest extends NsTest {
    InputView inputView = new InputView();
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("R\nU", "U"),
                Arguments.of("R\nA\nD","D")
        );
    }

    @DisplayName("올바른 입력 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    public void movementInputTest(String input) {
        consoleTestUtil.setInput(input);
        String move = inputView.readMoving();
        assertThat(move).isEqualTo(input);
    }

    @DisplayName("사용자 이동 예외 테스트")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    public void movementException(String input) {
        consoleTestUtil.setInput(input);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("반복 입력 테스트")
    @MethodSource("testCases")
    @ParameterizedTest
    public void movementLoopInputException(String input, String expected) {
        assertSimpleTest(() -> {
            consoleTestUtil.setInput(input);
            String move = inputView.loopInput(() -> inputView.readMoving());
            assertThat(move).isEqualTo(expected);
            assertThat(output()).contains(ErrorMsg.NOT_ALLOWED_MOVEMENT.toString());
        });
    }

    @Override
    protected void runMain() {}
}
