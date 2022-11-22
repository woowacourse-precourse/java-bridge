package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @DisplayName("올바른 사이즈가 입력 될 때 까지 입력값 요구")
    @Test
    void getBrideSizeTest() {
        List<String> inputs = List.of("0", "aa", "100", "28", "pp", "K", "3");
        String inputWithDivision = String.join("\n", inputs);
        System.setIn(new ByteArrayInputStream(inputWithDivision.getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        InputView inputView = new InputView();
        inputView.getBrideSize();

        String [] result = byteArrayOutputStream.toString().split("\n");
        for (String resultAll : result) {
            assertThat(resultAll).contains("ERROR");
        }
    }

    @DisplayName("올바른 moving 커맨드가 입력 될 때 까지 입력값 요구")
    @Test
    void getReadMoving() {
        List<String> inputs = List.of("0", "aa", "100", "28", "pp", "K", "U");
        String inputWithDivision = String.join("\n", inputs);
        System.setIn(new ByteArrayInputStream(inputWithDivision.getBytes()));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        InputView inputView = new InputView();
        inputView.getReadMoving();

        String [] result = byteArrayOutputStream.toString().split("\n");
        for (String resultAll : result) {
            assertThat(resultAll).contains("ERROR");
        }
    }

    @Test
    void getReadCommand() {
    }
}