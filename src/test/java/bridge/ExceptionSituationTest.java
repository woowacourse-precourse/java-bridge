package bridge;

import bridge.domain.Validation;
import bridge.ui.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class ExceptionSituationTest {
    private static final InputView inputView = new InputView();

    private InputStream setInputStream(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("다리의 길이로 정수가 아닌 값이 입력되면 예외가 발생한다.")
    @Test
    void inputBridgeSizeNotIntTest() {
        InputStream inputStream = setInputStream("notInt");
        System.setIn(inputStream);
        assertThatThrownBy(inputView::readBridgeSize).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 다리의 길이가 3 미만, 20 초과이면 예외가 발생한다.")
    @Test
    void inputBridgeSizeOutOfBoundsTest() {
        InputStream inputStream = setInputStream("30");
        System.setIn(inputStream);
        assertThatThrownBy(inputView::readBridgeSize)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력된 이동할 칸 정보가 U나 D가 아닌 경우 예외가 발생한다.")
    @Test
    void inputForMoveNotUOrDTest() {
        InputStream inputStream = setInputStream("wrong input");
        System.setIn(inputStream);
        assertThatThrownBy(inputView::readMoving)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시도 여부에 대한 응답이 R 또는 Q가 아닌 경우 예외가 발생한다." )
    @Test
    void inputAfterFailureNotROrQTest() {
        InputStream inputStream = setInputStream("wrong input");
        System.setIn(inputStream);
        assertThatThrownBy(inputView::readGameCommand)
                .isInstanceOf(IllegalArgumentException.class);
    }

}
