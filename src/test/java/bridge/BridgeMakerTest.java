package bridge;

import bridge.domain.BridgeMaker;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void 다리_생성_테스트() {
        List<String> bridge = bridgeMaker.makeBridge(Randoms.pickNumberInRange(3, 20));
        assertThat(bridge.stream().allMatch(this::isMoving)).isTrue();

    }

    private boolean isMoving(String moving) {
        if (moving.equals("U")) {
            return true;
        }
        if (moving.equals("D")) {
            return true;
        }
        return false;
    }
}
