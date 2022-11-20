package bridge;

import bridge.presentation.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @DisplayName("다리 길이를 입력한다.")
    @Test
    void inputBridgeSizeTest() {
        String input = "3";
        int expected = 3;

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int bridgeSize = inputView.readBridgeSize();
        assertEquals(expected, bridgeSize);
    }

    @DisplayName("다리 길이를 잘못 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "23", "100f"})
    void inputBridgeSizeErrorTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> inputView.readBridgeSize());

        assertTrue(exception.getMessage().contains(ERROR_MESSAGE));
    }

    @DisplayName("라운드마다 플레이어가 이동할 칸을 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void inputMoveTest(String input) {

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String move = inputView.readMoving();
        assertEquals(input, move);
    }

    @DisplayName("라운드마다 플레이어가 이동할 칸을 잘못 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"RE", "Q", ""})
    void inputMoveErrorTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> inputView.readMoving());

        assertTrue(exception.getMessage().contains(ERROR_MESSAGE));
    }

    @DisplayName("게임 재시작/종료 여부를 입력한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R", "Q"})
    void inputRetryCommandTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        String retryCommand = inputView.readGameCommand();

        assertEquals(input, retryCommand);
    }

    @DisplayName("게임 재시작/종료 여부를 잘못 입력하면 오류가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"UD", "D", ""})
    void inputRetryCommandErrorTest(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> inputView.readGameCommand());

        assertTrue(exception.getMessage().contains(ERROR_MESSAGE));
    }
}