package bridge;

import org.junit.jupiter.api.*;

import java.io.*;

import static bridge.enums.ErrorMessage.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
    }

    @DisplayName("다리의 길이 입력시 범위(3~20)를 벗어나거나 정수가 아닐시 예외가 발생한다")
    @Nested
    class 다리_길이_예외 {
        @Test
        void case_문자_입력() {
            String input = "18k";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                    inputView.getBridgeLength());
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());
        }

        @Test
        void case_범위_밖_입력() {
            String input = "21";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                    inputView.getBridgeLength());
            assertEquals(ER_BRIDGE_LENGTH_INPUT.getMessage(), illegalArgumentException.getMessage());
        }
    }
    @DisplayName("이동할 값 입력시 U,D가 아닐경우 예외가 발생한다.")
    @Nested
    class 다리_이동_입력_예외 {
        @Test
        void case_1() {
            String input = "업";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                    inputView.readMoving());
            assertEquals(ER_NOT_D_OR_U.getMessage(), illegalArgumentException.getMessage());
        }
        @Test
        void case_2() {
            String input = "u";
            OutputStream out = new ByteArrayOutputStream();
            System.setOut(new PrintStream(out));
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () ->
                    inputView.readMoving());
            assertEquals(ER_NOT_D_OR_U.getMessage(), illegalArgumentException.getMessage());
        }
    }

}