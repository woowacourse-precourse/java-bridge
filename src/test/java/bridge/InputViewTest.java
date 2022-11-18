package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    @DisplayName("다리 길이가 3 이상 20 이하 숫자라면 통과한다.")
    void readBridgeSize_정상_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.readBridgeSize())
                .isEqualTo(Integer.parseInt(input));
    }
    @ParameterizedTest
    @ValueSource(strings = {"20a", "", "a", " ", "21", "1", "-1"})
    @DisplayName("다리 길이가 3~20 사이의 숫자가 아니라면 예외가 발생한다.")
    void readBridgeSize_예외_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readBridgeSize);
    }

    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    @DisplayName("이동할 칸이 U, D라면 통과한다.")
    void readMoving_정상_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"F", "G", "1", ""})
    @DisplayName("이동할 칸이 U, D가 아니라면 예외가 발생한다.")
    void readMoving_예외_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readMoving);
    }

    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    @DisplayName("커맨드가 R, Q라면 통과한다.")
    void readGameCommand_정상_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"W", "T", " ", "1"})
    @DisplayName("커맨드가 R, Q가 아니라면 예외가 발생한다.")
    void readGameCommand_예외_입력(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::readGameCommand);
    }
}