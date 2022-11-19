package bridge.view;

import bridge.InputView;
import bridge.Move;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InputViewTest {

    InputView inputView = new InputView();

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    private static Stream<Arguments> provideInvalidSize() {
        return Stream.of(
                Arguments.of("2"),
                Arguments.of("야호"),
                Arguments.of("\0")
        );
    }

    @DisplayName("다리의 길이로 3이상 20이하의 숫자외의 입력시 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidSize")
    void inputBridgeSizeInvalid(String input) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideValidSize() {
        return Stream.of(
                Arguments.of("3", 3),
                Arguments.of("20", 20)
        );
    }

    @DisplayName("다리의 길이로 3이상 20이하의 숫자 입력시 해당 수를 반환한다")
    @ParameterizedTest
    @MethodSource("provideValidSize")
    void inputBridgeSizeValid(String input, int expectedSize) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThat(inputView.readBridgeSize()).isEqualTo(expectedSize);
    }

    private static Stream<Arguments> provideInvalidMoving() {
        return Stream.of(
                Arguments.of("\0"),
                Arguments.of("UU"),
                Arguments.of("ㅠㅠ")
        );
    }

    @DisplayName("움직일 위치로 U 혹은 D 한글자 이외를 입력한 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidMoving")
    void inputMovingInvalid(String input) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideValidMoving() {
        return Stream.of(
                Arguments.of("U", Move.U),
                Arguments.of("D", Move.D)
        );
    }

    @DisplayName("움직일 위치로 U 혹은 D 한글자를 입력한 경우 해당 문자를 반환한다")
    @ParameterizedTest
    @MethodSource("provideValidMoving")
    void inputMovingValid(String input, Move expectedMoving) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThat(inputView.readMoving()).isEqualTo(expectedMoving);
    }

    private static Stream<Arguments> provideInvalidGameCommand() {
        return Stream.of(
                Arguments.of("알"),
                Arguments.of("큐"),
                Arguments.of("RR"),
                Arguments.of("QQ"),
                Arguments.of("\0")
        );
    }

    @DisplayName("재시작 여부로 R 혹은 Q 한글자 외를 입력한 경우 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidGameCommand")
    void inputGameCommandInvalid(String input) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideValidGameCommand() {
        return Stream.of(
                Arguments.of("R", "R"),
                Arguments.of("Q", "Q")
        );
    }

    @DisplayName("재시작 여부로 R 혹은 Q 한글자를 입력한 경우 해당 문자를 반환한다")
    @ParameterizedTest
    @MethodSource("provideValidGameCommand")
    void inputGameCommandValid(String input, String expectedGameCommand) {
        InputStream inputStream = generateUserInput(input);
        System.setIn(inputStream);

        assertThat(inputView.readGameCommand()).isEqualTo(expectedGameCommand);
    }
}
