package bridge.view;

import bridge.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    InputView inputView = new InputView();

    @DisplayName("다리의 길이로 3이상 20이하의 숫자외의 입력시 예외가 발생한다")
    @Test
    void inputBridgeSizeInvalid() {
        assertThatThrownBy(() -> inputView.readBridgeSize(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readBridgeSize("76"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readBridgeSize("이십"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리의 길이로 3이상 20이하의 숫자 입력시 해당 수를 반환한다")
    @Test
    void inputBridgeSizeValid() {
        assertThat(inputView.readBridgeSize("20")).isEqualTo(20);
    }

    @DisplayName("움직일 위치로 U 혹은 D 한글자 이외를 입력한 경우 예외가 발생한다")
    @Test
    void inputMovingInvalid() {
        assertThatThrownBy(() -> inputView.readMoving(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readMoving("UU"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readMoving("유유"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("움직일 위치로 U 혹은 D 한글자를 입력한 경우 해당 문자를 반환한다")
    @Test
    void inputMovingValid() {
        assertThat(inputView.readMoving("U")).isEqualTo("U");
        assertThat(inputView.readMoving("D")).isEqualTo("D");
    }

    @DisplayName("움직일 위치로 R 혹은 Q 한글자 외를 입력한 경우 예외가 발생한다")
    @Test
    void inputGameCommandInvalid() {
        assertThatThrownBy(() -> inputView.readGameCommand(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readGameCommand("큐"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputView.readGameCommand("RR"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 여부로 R 혹은 Q 한글자를 입력한 경우 해당 문자를 반환한다")
    @Test
    void inputGameCommandValid() {
        assertThat(inputView.readGameCommand("R")).isEqualTo("R");
        assertThat(inputView.readGameCommand("Q")).isEqualTo("Q");
    }


}
