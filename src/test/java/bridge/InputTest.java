package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import bridge.View.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class InputTest {
    private static MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("생성할 다리 길이를 정상적으로 입력받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20", "17", "9"})
    void getBridgeSize(String input) {
        when(Console.readLine()).thenReturn(input);

        InputView inputView = new InputView();

        assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(input));
    }

}
