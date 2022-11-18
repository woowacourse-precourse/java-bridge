package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @DisplayName("다리 길이 범위내에 존재하는 값을 입력시 성공한다.")
    @Test
    void readBridgeSizeTest() {
        IntStream.rangeClosed(3, 20)
                .mapToObj(i -> String.valueOf(i))
                .forEach(input -> inputView.validateBridgeSize(input));
    }

    @ParameterizedTest(name = "다리 길이 범위에 벗어나는 {0}를 입력시 예외가 발생힌다.")
    @ValueSource(strings = {"2, 21"})
    void readBridgeSizeExceptionTest(String input) {
        assertThatThrownBy(() -> inputView.validateBridgeSize(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
