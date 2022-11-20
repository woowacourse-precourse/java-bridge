package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private static final String INPUT_TYPE_IS_NOT_PROPER = "[ERROR] 잘못된 입력 형식입니다.";

    Scanner scanner;

    private InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @Test
    @DisplayName("다리의 길이 입력 형식이 적절하지 않다면 에러를 발생시킨다.")
    void inputBridgeSizeTypeImproperly() {
        InputView inputView = new InputView();
        String size = "십";
        InputStream in = generateUserInput(size);
        System.setIn(in);
        scanner = new Scanner(System.in);

        assertThatThrownBy(() -> inputView.readBridgeSize())
                .isInstanceOf(RuntimeException.class)
                .hasMessage(INPUT_TYPE_IS_NOT_PROPER);
    }
}