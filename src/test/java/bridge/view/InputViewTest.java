package bridge.view;

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
                                                                .hasMessageContaining("[ERROR]");
        }
    }

    @DisplayName("예외 시나리오 | 다리 길이 범위에서 벗어난 수 입력 시 예외 처리")
    @ParameterizedTest
    @CsvSource({"-1", "0", "23"})
    void readBridgeSizeByConsoleIllegalRangeNumber(String illegalRangeNumber) {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(Console.readLine()).thenReturn(illegalRangeNumber);

            assertThatThrownBy(() -> inputView.readBridgeSize()).isInstanceOf(IllegalArgumentException.class)
                                                                .hasMessageContaining("[ERROR]");
        }
    }

}
