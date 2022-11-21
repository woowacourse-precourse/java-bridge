package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    Scanner scanner = new Scanner(System.in);
    private final PrintStream standardOutputStream = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    InputView inputView = new InputView();

    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void restoreStream() {
        System.setOut(standardOutputStream);
        outputStream.reset();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("다리 길이 유효성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "d", "21", " "})
    void readBridgeSizeTest(String size) {
        InputStream inputStream = generateUserInput(size);
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자 이동 유효성 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1", "d", "u", " "})
    void readMoving(String move) {
        InputStream inputStream = generateUserInput(move);
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도, 종료 유효성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"r", "q", " ", "1"})
    void readCommand(String command) {
        InputStream inputStream = generateUserInput(command);
        System.setIn(inputStream);
        scanner = new Scanner(System.in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }
}