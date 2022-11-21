package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {
    private final InputView inputView = new InputView();

    @DisplayName("숫자만입력가능")
    @Test
    void readBridgeSize1() {
        String input = "1ab";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("3이상 20이하의 사이즈만 가능")
    @Test
    void readBridgeSize2() {
        String input1 = "2";
        InputStream in1 = new ByteArrayInputStream(input1.getBytes());
        System.setIn(in1);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);

        String input2 = "21";
        InputStream in2 = new ByteArrayInputStream(input2.getBytes());
        System.setIn(in2);
        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("U 또는 D이외의 값 입력시 예외발생")
    @Test
    void readMoving() {
        for(var alphabet : List.of("A", "B" ,"C", "ASD", "U", "D")){
        String input = alphabet;
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            if(!(alphabet.equals("U") || alphabet.equals("D")))
            assertThatThrownBy(() -> inputView.readMoving())
                .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @DisplayName("R 또는 Q이외의 값 입력시 예외발생")
    @Test
    void readGameCommand() {
        for(var alphabet : List.of("A", "B" ,"C", "ASD", "U", "D", "R", "Q", "U", "D")){
            String input = alphabet;
            InputStream in = new ByteArrayInputStream(input.getBytes());
            System.setIn(in);
            if(!(alphabet.equals("R") || alphabet.equals("Q")))
                assertThatThrownBy(() -> inputView.readGameCommand())
                        .isInstanceOf(IllegalArgumentException.class);
        }
    }
}