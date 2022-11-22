package bridge.view.inputView;

import static org.assertj.core.api.Assertions.*;

import bridge.view.InputView;
import bridge.view.InputViewImpl;
import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("다리 크기 입력을 받을 때에는")
public class InputViewBridgeSizeTest {

    private final InputView inputView = new InputViewImpl();
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("3 ~ 20의 숫자를 입력 받는다.")
    @ParameterizedTest
    @MethodSource("PassingTestParams")
    void PassingTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        inputView.readBridgeSize();
    }

    private static Stream<String> PassingTestParams() {
        return Stream.of(
                "3",
                "10",
                "17",
                "20"
        );
    }

    @DisplayName("입력이 숫자로만 이루어져 있어야 한다.")
    @ParameterizedTest
    @MethodSource("numberFailTestParams")
    void numberFailTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEAD);
    }

    private static Stream<String> numberFailTestParams() {
        return Stream.of(
                "aHundredAndTwentyThree",
                "백이십삼",
                "1e3"
        );
    }

    @DisplayName("입력이 3 ~ 20 범위의 숫자여야 한다.")
    @ParameterizedTest
    @MethodSource("rangeFailTestParams")
    void rangeFailTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith(ERROR_HEAD);
    }

    private static Stream<String> rangeFailTestParams() {
        return Stream.of(
                "0",
                "2",
                "21",
                "100"
        );
    }
}
