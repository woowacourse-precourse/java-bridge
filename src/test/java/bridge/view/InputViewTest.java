package bridge.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {
    InputView inputView = new InputView();

    @ParameterizedTest
    @ValueSource(strings = {"a\n" + "21\n" + "3"})
    @DisplayName("다리 크기 입력값이 잘못되면 오류메시지 출력 후 재입력 받는다..")
    void readBridgeSize_InputByInvalidValue_ReInputUntilValidValue(String input) {
        // TODO: exception을 컨트롤해줘서 그걸 검증하면 안됨 Exception이 안던져짐
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThat(inputView.readBridgeSize()).isEqualTo(3);
        assertThat(out.toString()).contains(
                "[ERROR] 숫자를 입력하세요.",
                "[ERROR] 3 이상 20 이하의 자연수를 입력하세요.");
    }

}