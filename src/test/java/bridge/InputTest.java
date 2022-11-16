package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import bridge.Utils.ExceptionType;
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

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
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

        InputView inputView = new InputView();

        assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("입력받은 다리 길이가 숫자가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"3Three", "!1l", "twenty"})
    void getBridgeSizeByNotNumber(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_NUMBER.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 다리 길이가 주어진 다리 최소 길이보다 작은 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "0", "2"})
    void getBridgeSizeByLowerThanBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_LOWER_THAN_MIN_BRIDGE_SIZE.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("입력받은 다리 길이가 주어진 다리 최대 길이보다 큰 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"21", "999", "23"})
    void getBridgeSizeByHigherThanBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_HIGHER_THAN_MAX_BRIDGE_SIZE.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("정상적인 이동할 칸을 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void getMoving(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("이동할 칸을 입력받을 때 알파벳이 아닌 값이 입력된 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"!", "0", "77tT", "Up!"})
    void getMovingByNotOnlyAlphabet(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_ONLY_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("이동할 칸을 입력받을 때 알파벳이 한 개가 아닌 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"uu", "UU", "UD", "ud", "rr"})
    void getMovingByNotOneAlphabet(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_ONE_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

    @DisplayName("이동할 칸을 입력받을 때 알파벳이 소문자인 경우 에러를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", "r", "z"})
    void getMovingByLowerAlphabet(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionType.IS_NOT_UPPER_ALPHABET.getMessage())
                .hasMessageContaining(ERROR);
    }

}
