package bridge.view.input;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class InputViewTest {

    private MockedStatic<Console> mockConsole;

    @Test
    void inputContentTest_checkRepeatReadingLine_whenFormIsNotMatched() {
        when(Console.readLine()).thenReturn("1", "90T", "77", "10","13");

        int result = new InputView().readBridgeSize();

        assertThat(result).isEqualTo(10);
    }

    @BeforeEach
    void mockClass() {
        mockConsole = mockStatic(Console.class);
    }

    @AfterEach
    void closMockClass() {
        mockConsole.close();
    }
}
