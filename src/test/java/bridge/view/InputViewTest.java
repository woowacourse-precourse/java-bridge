package bridge.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("다리 건너기 게임 입력에 대해,")
public class InputViewTest {

    private final InputView inputView = new InputViewImpl();
    private static final String ERROR_HEAD = "[ERROR]";

    @DisplayName("다리 크기 입력을 받을 때에는")
    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    class readBridgeSizeTest {

        @DisplayName("3 ~ 20의 숫자를 입력 받는다.")
        @ParameterizedTest
        @MethodSource("PassingTestParams")
        void PassingTest(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readBridgeSize();
        }

        private Stream<String> PassingTestParams() {
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

        private Stream<String> numberFailTestParams() {
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

        private Stream<String> rangeFailTestParams() {
            return Stream.of(
                    "0",
                    "2",
                    "21",
                    "100"
            );
        }
    }

    @DisplayName("게임 진행 명령어 입력을 받을 때에는")
    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    class readMovingTest {

        @DisplayName("U, D 중 하나를 입력 받는다.")
        @ParameterizedTest
        @MethodSource("PassingTestParams")
        void PassingTest(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readMoving();
        }

        private Stream<String> PassingTestParams() {
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

        private Stream<String> commandFailTestParams() {
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

    @DisplayName("종료/재시작 명령어 입력을 받을 때에는")
    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    class readGameCommandTest {

        @DisplayName("R, Q 중 하나를 입력 받는다.")
        @ParameterizedTest
        @MethodSource("PassingTestParams")
        void PassingTest(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            inputView.readGameCommand();
        }

        private Stream<String> PassingTestParams() {
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
            assertThatThrownBy(inputView::readGameCommand)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageStartingWith(ERROR_HEAD);
        }

        private Stream<String> commandFailTestParams() {
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
}
