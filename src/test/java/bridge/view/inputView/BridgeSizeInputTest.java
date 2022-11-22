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


class BridgeSizeInputTest extends NsTest {
    InputView inputView = new InputView();
    ConsoleTestUtil consoleTestUtil = new ConsoleTestUtil();

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1\n20", 20),
                Arguments.of("aaa\n3",3),
                Arguments.of("21\n10",10)
        );
    }

    @DisplayName("입력 예외 테스트")
    @ValueSource(strings = {"dddd", "1", "21"})
    @ParameterizedTest
    public void inputException(String input) {
        consoleTestUtil.setInput(input);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 예외 발생 시 다시 입력")
    @MethodSource("testCases")
    @ParameterizedTest
    public void loopInputTest(String input, int expected) {
        consoleTestUtil.setInput(input);
        assertSimpleTest(
                () -> {
                    Integer size = inputView.loopInput(() -> inputView.readBridgeSize());
                    assertThat(size).isEqualTo(expected);
                    assertThat(output()).contains(List.of(ErrorMsg.WRONG_BRIDGE_SIZE.toString()));
                });
    }

    @Override
    protected void runMain() {
    }
}