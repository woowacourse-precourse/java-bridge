package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.input.InputView;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    InputView inputView = new InputView();
    @DisplayName("readBridgeSize 에 잘못된 입력이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"20l", "2", "-15", "30", "무성", "\n\t", "3a", " ", ""})
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
    @DisplayName("readGameCommandeSize 에 잘못된 입력이 주어지면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"QR", "q", "ㅂ", " R", " Q", "무성", "\n\t", " ", ""})
    void wrongInputToReadGameCommand(String input) {
        settingInput(input);
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("readBridgeSize에 올바른 입력이 주어지면 int로 변환되어 리턴된다.")
    @Test
    void readBridgeSizeReturnCheck() {
        settingInput("5");
        assertThat(inputView.readBridgeSize()).isEqualTo(5);
    }

    @DisplayName("readMoving에 올바른 입력이 주어지면 String이 리턴된다.")
    @Test
    void readMovingReturnCheck() {
        settingInput("D");
        assertThat(inputView.readMoving()).isEqualTo("D");
    }
    @DisplayName("readGameCommand에 올바른 입력이 주어지면 String이 리턴된다.")
    @Test
    void readGameCommandReturnCheck() {
        settingInput("Q");
        assertThat(inputView.readGameCommand()).isEqualTo("Q");
    }
    void settingInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
