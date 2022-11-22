package bridge;

import bridge.domain.MyBridge;
import bridge.validate.Validator;
import bridge.view.InputView;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker;
    private static MockedStatic<InputView> inputView;

    @BeforeEach
    public void init() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @BeforeAll
    public static void beforeALl() {
        inputView = mockStatic(InputView.class);
    }

    @AfterAll
    public static void afterAll() {
        inputView.close();
    }

    @DisplayName("다리 사이즈를 입력하면 리스트형태의 다리가 생성된다")
    @Test
    void makeBridge() throws Exception{
        when(InputView.readBridgeSize()).thenReturn(3);
        Assertions.assertEquals(bridgeMaker.inputBridgeSize().size(), 3);
    }

    @DisplayName("범위를 벗어나는 다리 사이즈면 IllegalArgumentException가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"0", "1", "123"})
    void moveCorrectMyBridge(int input) throws Exception{
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateSizeRange(input));
    }
}
