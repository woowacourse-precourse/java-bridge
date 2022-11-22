package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    InputView inputView;
    InputStream in;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    void setIn(String input) {
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @DisplayName("다리사이즈 올바른 입력 테스트")
    @Test
    void sizeTest() {
        String[] input = {"3", "10", "20"};
        int[] result = {3, 10, 20};
        for (int i = 0; i < 3; i++) {
            in = new ByteArrayInputStream(input[i].getBytes());
            System.setIn(in);
            int size = inputView.readBridgeSize();
            assertThat(size).isEqualTo(result[i]);
        }
    }

    @DisplayName("다리사이즈 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"40", "0", "2", "qwe", "oo"})
    void sizeErrorTest(String input) {
        setIn(input);
        assertThatThrownBy(() -> {
            inputView.readBridgeSize();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D", "u", "d"})
    void moveTest(String input) {
        String[] result = {"U", "D"};
        setIn(input);
        String move = inputView.readMoving();
        assertThat(result).contains(move);
    }

    @DisplayName("이동 입력 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"a", "x", "Q", "l", "UU", "DD"})
    void moveErrorTest(String input) {
        setIn(input);
        assertThatThrownBy(() -> {
            inputView.readMoving();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 종료 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q", "r", "q"})
    void retryQuitTest(String input) {
        String[] result = {"R", "Q"};
        setIn(input);
        String command = inputView.readGameCommand();
        assertThat(result).contains(command);
    }

    @DisplayName("재시작 종료 입력 에러 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"qq", "Qq", "hj", "k", "retry"})
    void retryQuitErrorTest(String input) {
        setIn(input);
        assertThatThrownBy(() -> {
            inputView.readGameCommand();
        }).isInstanceOf(IllegalArgumentException.class);
    }
}