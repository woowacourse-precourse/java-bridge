package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

class InputViewTest {

    InputView inputView;

    @BeforeEach
    void init() {
        inputView = new InputView();
    }

    @DisplayName("콘솔에서 다리 길이를 입력 받는다. | 정상 시나리오")
    @Test
    void readBridgeSizeByConsole() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            String testBridgeSize = "3";

            when(Console.readLine()).thenReturn(testBridgeSize);

            assertThat(inputView.readBridgeSize()).isEqualTo(3);
        }
    }

    @DisplayName("다리 길이 숫자가 아닌 값 입력 시 예외 처리 | 예외 시나리오")
    @Test
    void readBridgeSizeByConsoleIllegalValue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            String illegalValue = "IllegalValue";

            when(Console.readLine()).thenReturn(illegalValue);

            assertThatThrownBy(() -> inputView.readBridgeSize())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR]");
        }
    }

}
