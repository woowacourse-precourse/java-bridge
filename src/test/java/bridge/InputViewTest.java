package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class InputViewTest {
    private static final InputView inputView = new InputView();

    @DisplayName("잘못된 다리 길이를 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"3j", "", "45", "0", "200000000000000000000000"})
    void invalidBridgeSizeInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.validateBridgeSize(input));
    }

    @DisplayName("올바른 다리 길이를 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"3", "20"})
    void validBridgeSizeInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputView.validateBridgeSize(input));
    }

    @DisplayName("잘못된 이동할 칸을 입력 받으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"u", "d", ""})
    void invalidMovingInputTest(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> inputView.validateMoving(input));
    }

    @DisplayName("올바른 이동할 칸을 입력 받으면 예외가 발생하지 않는다")
    @ParameterizedTest
    @ValueSource(strings = {"U", "D"})
    void validMovingInputTest(String input) {
        assertThatNoException()
                .isThrownBy(() -> inputView.validateMoving(input));
    }
}
