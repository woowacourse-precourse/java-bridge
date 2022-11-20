package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {

    private static BridgeGame bridgeGame;
    @DisplayName("move 기능 테스트")
    @Test
    void moveTest() {
        bridgeGame = new BridgeGame(5);
        List<String> realBridge = bridgeGame.getRealBridge();

        for (int i = 0; i < 5; i++) {
            assertThat(bridgeGame.getCurrentLocation() == i);
            assertThat(bridgeGame.move(realBridge.get(i)));
        }
    }
}
