package bridge.view;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

import bridge.ConsoleReader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class InputViewTest {

    private static MockedStatic<ConsoleReader> consoleReader;
    private final InputView inputView = new InputView();

    @BeforeEach
    void beforeEach() {
        consoleReader = mockStatic(ConsoleReader.class);
    }

    @AfterEach
    void afterEach() {
        consoleReader.close();
    }

    @DisplayName("readBridgeSize 예외 발생시 다시 입력이 재시작해야함")
    @Test
    void RetryReadBridgeSizeFunctionWhenCatchIllegalArgumentException() {
        // given
        final int INVALID_VALUE = 1;
        final int VALID_VALUE = 3;
        consoleReader.when(ConsoleReader::readInt).thenReturn(INVALID_VALUE, INVALID_VALUE, VALID_VALUE);

        // when
        inputView.readBridgeSize();

        // then
        consoleReader.verify(ConsoleReader::readInt, times(3));
    }

    @DisplayName("readMoving 예외 발생시 다시 입력이 재시작해야함")
    @Test
    void RetryReadMovingFunctionWhenCatchIllegalArgumentException() {
        // given
        final String INVALID_VALUE = "UP";
        final String VALID_VALUE = "U";
        consoleReader.when(ConsoleReader::readString).thenReturn(INVALID_VALUE, INVALID_VALUE, VALID_VALUE);

        // when
        inputView.readMoving();

        // then
        consoleReader.verify(ConsoleReader::readString, times(3));
    }

    @DisplayName("readMoving 예외 발생시 다시 입력이 재시작해야함")
    @Test
    void RetryReadGameCommandFunctionWhenCatchIllegalArgumentException() {
        // given
        final String INVALID_VALUE = "RETRY";
        final String VALID_VALUE = "R";
        consoleReader.when(ConsoleReader::readString).thenReturn(INVALID_VALUE, INVALID_VALUE, VALID_VALUE);

        // when
        inputView.readGameCommand();

        // then
        consoleReader.verify(ConsoleReader::readString, times(3));
    }
}