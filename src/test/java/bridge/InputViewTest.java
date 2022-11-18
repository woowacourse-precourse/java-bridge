package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {
    InputView inputView = new InputView();
    @DisplayName("readBridgeSize 에 잘못된 입력이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"20l", "2", "-15", "30", "무성", "\n\t", "", "3a"})
    void wrongInputToReadBridgeSize(String input) {
        settingInput(input);
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("readMoving 에 잘못된 입력이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"DU", "ㅇ", "ㅕ", "U ", "무성", "\n\t", " ", ""})
    void wrongInputToReadMoving(String input) {
        settingInput(input);
        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("readBridgeSize 에 잘못된 입력이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"QR", "q", "ㅂ", " R", " Q", "무성", "\n\t", "", " "})
    void wrongInputToReadGameCommand(String input) {
        settingInput(input);
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class);
    }
    void settingInput(String input){
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
