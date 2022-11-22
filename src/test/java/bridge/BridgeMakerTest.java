package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BridgeMakerTest {
    @DisplayName("3~20 범위의 값이 입력되면 정상적으로 다리가 생성되어 반환된다.")
    @Test
    void makeBridge_with_valid_input() {
        assertRandomNumberInRangeTest(() -> {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            assertThat(bridgeMaker.makeBridge(4)).isEqualTo(List.of("U","D","U","U"));
        }, 1, 0, 1, 1);
    }
}
