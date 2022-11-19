package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();

    @DisplayName("다리 사이즈 input시, 3이상 20이하의 길이를 넣지 않은 경우 예외가 발생한다.")
    @Test
    void inputBridgeSizeWrong() {
            String input = "21";
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);

            assertThatThrownBy(() ->
                inputView.readBridgeSize()
            ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 칸 input시, U, D 이외의 문자를 넣은 경우.")
    @Test
    void inputMovingWrong() {
        String input = "M";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() ->
                inputView.readMoving()
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("게임 진행 input시, R, Q 이외의 문자를 넣은 경우.")
    @Test
    void input() {
        String input = "S";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() ->
                inputView.readGameCommand()
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
