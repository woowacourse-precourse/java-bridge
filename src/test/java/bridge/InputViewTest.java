package bridge;

import bridge.io.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class InputViewTest {
    private InputView inputView;

    private InputStream inputStream;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    void inputStreamInit(String input) {
        inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @DisplayName("숫자가 아닌 값을 입력하면 예외 발생")
    @Test
    void 잘못된_다리_입력() {
        final String input = "a";
        inputStreamInit(input);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3-20 사이가 아닌 값을 입력하면 예외 발생")
    @Test
    void 잘못된_다리_사이즈_입력() {
        final String input = "200";
        inputStreamInit(input);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 값을 입력하는 경우 정상 통과")
    @Test
    void 정상_다리_사이즈_입력() {
        final String input = "10";
        inputStreamInit(input);
        assertDoesNotThrow(() -> inputView.readBridgeSize());
    }

    @DisplayName("U 또는 D 이외의 값을 입력하는 경우 예외 발생")
    @Test
    void 잘못된_이동_위치_입력() {
        final String input = "A";
        inputStreamInit(input);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("정상 이동 위치 U를 입력하는 경우 정상 통과")
    @Test
    void 정상_이동_위치_U_입력() {
        final String input = "U";
        inputStreamInit(input);
        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("정상 이동 위치 D를 입력하는 경우 정상 통과")
    @Test
    void 정상_이동_위치_D_입력() {
        final String input = "D";
        inputStreamInit(input);
        assertThat(inputView.readMoving()).isEqualTo(input);
    }

    @DisplayName("R 또는 Q 이외의 값을 입력하는 경우 예외 발생")
    @Test
    void 잘못된_커맨드_입력() {
        final String input = "A";
        inputStreamInit(input);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 커맨드 R를 입력하는 경우 정상 통과")
    @Test
    void 정상_커맨드_U_입력() {
        final String input = "R";
        inputStreamInit(input);
        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }

    @DisplayName("종료 커맨드 Q를 입력하는 경우 정상 통과")
    @Test
    void 정상_커맨드_Q_입력() {
        final String input = "Q";
        inputStreamInit(input);
        assertThat(inputView.readGameCommand()).isEqualTo(input);
    }
}