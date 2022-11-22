package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
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

        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(RuntimeException.class);
    }
}