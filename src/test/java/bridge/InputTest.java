package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import bridge.Utils.ExceptionType;
import bridge.Utils.Validation.ValidationForOneUpperAlphabet;
import bridge.View.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class InputTest {

    private static final String ERROR = "[ERROR]";
    private static MockedStatic<Console> console;
    private static InputView inputView;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
        inputView = new InputView();
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("생성할 다리 길이를 정상적으로 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "17", "9"})
    void getBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력받은 다리 길이가 숫자가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"3Three", "!1l", "twenty"})
    void getBridgeSizeByNotNumber(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_NUMBER.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 다리 길이가 주어진 다리 최소 길이보다 작은 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "2"})
    void getBridgeSizeByLowerThanBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.LOWER_THAN_MIN_BRIDGE_SIZE.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 다리 길이가 주어진 다리 최대 길이보다 큰 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"21", "999", "23"})
    void getBridgeSizeByHigherThanBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.HIGHER_THAN_MAX_BRIDGE_SIZE.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("정상적인 이동할 칸을 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void getMoving(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("이동할 칸을 입력받을 때 알파벳이 U와 D가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "T", "R", "Q"})
    void getMovingByNotMovingAlphabet(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_MOVING_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("정상적인 재시작/종료 여부를 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void getGameCommand(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }

    @DisplayName("재시작/종료 여부를 입력받을 때 알파벳이 R과 Q가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "A", "Z"})
    void getGameCommandByNotCommandAlphabet(String input) {
        when(Console.readLine()).thenReturn(input);

        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_GAME_COMMAND_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 값이 알파벳이 아닌 값이 입력된 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"!", "0", "77tT", "Up!"})
    void getOneUpperAlphabetByNotOnlyAlphabet(String input) {
        ValidationForOneUpperAlphabet onlyOneUpperAlpha = new ValidationForOneUpperAlphabet();

        assertThatThrownBy(() -> onlyOneUpperAlpha.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_ONLY_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 값이 알파벳이 한 개가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"uu", "UU", "UD", "ud", "rrr"})
    void getOneUpperAlphabetByNotOneAlphabet(String input) {
        ValidationForOneUpperAlphabet onlyOneUpperAlpha = new ValidationForOneUpperAlphabet();

        assertThatThrownBy(() -> onlyOneUpperAlpha.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_ONE_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 값이 알파벳이 소문자인 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "r", "q"})
    void getOneUpperAlphabetByLowerAlphabet(String input) {
        ValidationForOneUpperAlphabet onlyOneUpperAlpha = new ValidationForOneUpperAlphabet();

        assertThatThrownBy(() -> onlyOneUpperAlpha.check(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.NOT_UPPER_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }
}
