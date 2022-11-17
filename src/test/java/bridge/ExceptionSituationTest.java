package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class ExceptionSituationTest {
    private static final InputView inputView = new InputView();

    private InputStream setOutputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("다리의 길이로 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void inputBridgeLengthNotIntTest() {
        InputStream inputStream = setOutputStream("notInt");
        System.setIn(inputStream);
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 다리의 길이가 3 미만, 20 초과이면 예외가 발생한다.")
    @Test
    void inputBridgeLengthOutOfBoundsTest() {
        InputStream inputStream = setOutputStream("30");
        System.setIn(inputStream);
        int illegalLength = inputView.readBridgeSize();
        assertThatThrownBy(() -> Validation.validateLength(illegalLength))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
