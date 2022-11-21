package bridge.view;

import static bridge.constant.ErrorConstant.INPUT_DIRECTION_EXCEPTION;
import static bridge.constant.ErrorConstant.INPUT_GAME_COMMAND_EXCEPTION;
import static bridge.constant.ErrorConstant.INPUT_NUMBER_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @DisplayName("정상 시나리오 | 콘솔에서 다리 길이를 입력 받는다.")
    @Test
    void readBridgeSizeByConsole() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            String testBridgeSize = "3";

            when(Console.readLine()).thenReturn(testBridgeSize);

            assertThat(inputView.readBridgeSize()).isEqualTo(3);
        }
    }

    @DisplayName("예외 시나리오 | 다리 길이 숫자가 아닌 값 입력 시 예외 처리 ")
    @Test
    void readBridgeSizeByConsoleIllegalValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            String illegalValue = "IllegalValue";

            when(Console.readLine()).thenReturn(illegalValue);

            assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class)
                                                                .hasMessageContaining(INPUT_NUMBER_EXCEPTION.getMessage());
        }
    }

    @DisplayName("예외 시나리오 | 다리 길이 범위에서 벗어난 수 입력 시 예외 처리")
    @ParameterizedTest
    @CsvSource({"-1", "0", "23"})
    void readBridgeSizeByConsoleIllegalRangeNumber(String illegalRangeNumber) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(illegalRangeNumber);

            assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class)
                                                                .hasMessageContaining(INPUT_NUMBER_EXCEPTION.getMessage());
        }
    }

    @DisplayName("정상 시나리오 | 콘솔에서 이동 방향을 입력 받는다.")
    @ParameterizedTest
    @CsvSource({"U", "D"})
    void readDirectionByConsole(String direction) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(direction);

            assertThat(inputView.readDirection()).isEqualTo(direction);
        }
    }

    @DisplayName("예외 시나리오 | 이동 방향 값이 'U', 'D'가 아닐 경우 예외 처리")
    @ParameterizedTest
    @CsvSource({"u", "3 "})
    void readDirectionByConsoleIllegalDirection(String illegalDirection) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(illegalDirection);

            assertThatThrownBy(() -> inputView.readDirection()).isInstanceOf(IllegalArgumentException.class)
                                                                 .hasMessageContaining(INPUT_DIRECTION_EXCEPTION.getMessage());
        }
    }

    @DisplayName("정상 시나리오 | 콘솔에서 재시도를 입력 받는다.")
    @ParameterizedTest
    @CsvSource({"R", "Q"})
    void readGameCommandByConsole(String gameCommand) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(gameCommand);

            assertThat(inputView.readGameCommand()).isEqualTo(gameCommand);
        }
    }

    @DisplayName("예외 시나리오 | 이동 방향 값이 'U', 'D'가 아닐 경우 예외 처리")
    @ParameterizedTest
    @CsvSource({"r", "3"})
    void readGameCommandByConsoleIllegalDirection(String illegalGameCommand) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(illegalGameCommand);

            assertThatThrownBy(() -> inputView.readGameCommand()).isInstanceOf(IllegalArgumentException.class)
                                                                 .hasMessageContaining(INPUT_GAME_COMMAND_EXCEPTION.getMessage());
        }
    }

}
