package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class InputViewTest {

    InputView inputView = new InputView();

    @Test
    void 다리길이_예외검출() {
        List<String> inputs = Arrays.asList("1", "2", "21", "22", "2a", "bbb", "woowacourse");

        for (String input: inputs) {
            Assertions.assertThatThrownBy(() -> inputView.validateBridgeSize(input))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    void 다리길이_정상값() {
        List<String> inputs = Arrays.asList("3", "4", "19", "20");

        for (String input: inputs) {
            Assertions.assertThatNoException()
                    .isThrownBy(() -> inputView.validateBridgeSize(input));
        }
    }
}
