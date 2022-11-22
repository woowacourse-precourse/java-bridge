package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {

    @DisplayName("bridge 생성이 제대로 되는지 확인")
    @Test
    void checkRandomNumbers() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = 10;
        bridgeMaker.makeBridge(size);

        assertRandomNumberInRangeTest(
                () -> {
                    assertThat(bridgeMaker.makeBridge(size)).isEqualTo((List.of("U", "U", "U", "D", "D", "D", "D", "D", "U", "U")));
                }, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
