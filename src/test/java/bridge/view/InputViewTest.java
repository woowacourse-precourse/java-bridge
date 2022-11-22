package bridge.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    private final InputView inputView = new InputView();

    @ParameterizedTest
    @NullAndEmptySource
    void castToIntErrorTest(String input) {
        assertThatThrownBy(() -> inputView.castToInt(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
