package bridge;

import bridge.model.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeTest {

    @Test
    void 정해진_값이_아닌_값으로_다리가_생성되면_예외발생_test() {
        assertThatThrownBy(() -> new Bridge(List.of("U", "R", "R")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
