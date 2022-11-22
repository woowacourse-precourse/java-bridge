package bridge.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

class InputViewTest {

    private static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("입력값이 U 또는 D인 경우 예외를 반환하지 않는다.")
    @Test
    void inputValidMovingString() {
        InputStream in = generateUserInput("U");
        System.setIn(in);

        assertThat(InputView.readMoving()).isEqualTo("U");
    }

    @DisplayName("입력값이 U 또는 D가 아닌 경우 예외를 반환한다.")
    @Test
    void inputInValidMovingString() {
        InputStream in = generateUserInput("f");
        System.setIn(in);

        assertThatThrownBy(InputView::readMoving)
                .hasMessageContaining("[ERROR] 이동할 칸에 대한 입력이 잘못되었습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력값이 Q 또는 R인 경우 예외를 반환하지 않는다.")
    @Test
    void inputValidRestartString() {
        InputStream in = generateUserInput("Q");
        System.setIn(in);

        assertThat(InputView.readGameCommand()).isEqualTo("Q");
    }

    @DisplayName("입력값이 Q 또는 R가 아닌 경우 예외를 반환한다.")
    @Test
    void inputInValidRestartString() {
        InputStream in = generateUserInput("f");
        System.setIn(in);

        assertThatThrownBy(InputView::readGameCommand)
                .hasMessageContaining("[ERROR] 재시작 옵션 대한 입력이 잘못되었습니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }
}