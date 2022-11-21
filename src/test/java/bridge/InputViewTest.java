package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private InputView inputView = new InputView();
    private InputStream in;

    @DisplayName("다리 길이가 숫자 타입이 아닐 경우 오류가 발생한다.")
    @ValueSource(strings = {"1", "21", "aa"})
    @ParameterizedTest
    void wrongBridgeSize(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("다리 길이가 3~20 사이의 숫자인 경우 오류가 발생하지 않는다.")
    @ValueSource(strings = {"3", "15", "20"})
    @ParameterizedTest
    void correctBridgeSize(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(Integer.toString(inputView.readBridgeSize())).isEqualTo(input);
    }

    @DisplayName("이동 방향이 U 혹은 D이 아닌 경우 오류가 발생한다.")
    @ValueSource(strings = {"1", "Q", "d", "-"})
    @ParameterizedTest
    void wrongDirection(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readMoving()).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("이동 방향이 U 혹은 D인 경우 정상적으로 작동한다.")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void correctDirection(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("게임 종료 여부가 R 혹은 Q이 아닌 경우 오류가 발생한다.")
    @ValueSource(strings = {"1", "U", "q", "-"})
    @ParameterizedTest
    void wrongGameCommand(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> inputView.readGameCommand()).isInstanceOf(NoSuchElementException.class);
    }

    @DisplayName("게임 종료 여부가 R 혹은 Q인 경우 정상적으로 작동한다.")
    @ValueSource(strings = {"R", "Q"})
    @ParameterizedTest
    void correctGameCommand(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }
}
