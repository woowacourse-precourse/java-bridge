package bridge.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {
    private static InputView inputView;

    @BeforeAll
    static void beforeAll() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이 입력받는 테스트")
    @ParameterizedTest
    @CsvSource({"3,3", "10,10", "20,20"})
    void readBridgeSizeTest(String input, int expectedSize) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int size = inputView.readBridgeSize();
        assertThat(size).isEqualTo(expectedSize);
    }

    @DisplayName("다리 길이 입력받는 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"10j", "jjj", "1j0", "j10", "j"})
    void readBridgeSizeExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이동 위치 입력받는 테스트")
    @ParameterizedTest
    @CsvSource({"U,U", "D,D", "u,U", "d,D"})
    void readMovingTest(String input, String expectedMoving) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String moving = inputView.readMoving();
        assertThat(moving).isEqualTo(expectedMoving);
    }

    @DisplayName("이동 위치 입력받는 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"위", "아래", "A", "u1", "1d"})
    void readMoveExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("게임 재시작 입력받는 테스트")
    @ParameterizedTest
    @CsvSource({"Q,Q", "R,R", "q,Q", "r,R"})
    void readGameCommandTest(String input, String expectedGameCommand) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        String gameCommand = inputView.readGameCommand();
        assertThat(gameCommand).isEqualTo(expectedGameCommand);
    }

    @DisplayName("게임 재시작 입력받는 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"계속", "그만", "A", "q1", "1r"})
    void readGameCommandExceptionTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        assertThatThrownBy(() -> inputView.readGameCommand())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
