package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.model.Direction;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView;
    OutputStream out;

    @BeforeEach
    void test_Init() {
        inputView = new InputView();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("다리 크기 입력값이 잘못되면 오류메시지 출력 후 재입력 받는다.")
    void readBridgeSize_InputByInvalidValue_ReInputUntilValidValue() {
        System.setIn(new ByteArrayInputStream(
                ("a" + System.lineSeparator() + "21" + System.lineSeparator() + "3").getBytes()));

        assertThat(inputView.readBridgeSize()).isEqualTo(3);
        assertThat(out.toString()).contains(
                "[ERROR] 숫자를 입력하세요.",
                "[ERROR] 3 이상 20 이하의 자연수를 입력하세요.");
    }

    @Test
    @DisplayName("움직일 방향 입력값이 잘못되면 오류메시지 출력 후 재입력 받는다.")
    void readMoving_InputByInvalidValue_ReInputUntilValidValue() {
        System.setIn(new ByteArrayInputStream(
                ("u" + System.lineSeparator() + "0" + System.lineSeparator() + "U").getBytes()));

        assertThat(inputView.readMoving()).isEqualTo(Direction.U);
        assertThat(out.toString()).contains("[ERROR] U 또는 D를 입력하세요.");
    }


}