package bridge.domain;
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


public class MyBridgeTest {
    MyBridge myBridge;
    private static MockedStatic<InputView> inputView;


    @BeforeAll
    public static void beforeALl() {
        inputView = mockStatic(InputView.class);
    }

    @AfterAll
    public static void afterAll() {
        inputView.close();
    }

    @DisplayName("정답인 블록으로 이동하면 true를 반환한다.")
    @Test
    void moveCorrectMyBridge() throws Exception{
        myBridge = new MyBridge(List.of("U", "U", "D", "D"), List.of("U"));
        Assertions.assertEquals(myBridge.matchBlocks(), true);
    }

    @DisplayName("오답인 블록으로 이동하면 false를 반환한다.")
    @Test
    void moveIncorrectMyBridge() throws Exception{
        myBridge = new MyBridge(List.of("U", "U", "D", "D"), List.of("D"));
        Assertions.assertEquals(myBridge.matchBlocks(), false);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "d", "123"})
    @DisplayName("이동시 U와 D가 아니면 IllegalArgumentException이 발생한다.")
    void move_IllegalArgumentException(String input) throws Exception{
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateMove(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"D", "U"})
    @DisplayName("이동시 U와 D면 정상 작동.")
    void move(String input) throws Exception{
        Validator.validateMove(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"Q", "R"})
    @DisplayName("재시작시 Q와 R이면 정상 작동.")
    void reGame(String input) throws Exception{
        Validator.validateRetry(input);
    }

    @ParameterizedTest
    @CsvSource(value = {"A", "q"})
    @DisplayName("재시작시 Q와 R이 아니면 IllegalArgumentException이 발생한다.")
    void reGame_IllegalArgumentException(String input) throws Exception{
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> Validator.validateRetry(input));
    }
}
