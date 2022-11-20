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

    private static BridgeGame bridgeGame = new BridgeGame(5);;

    @DisplayName("move 기능 테스트")
    @Test
    void moveTest() {
        List<String> realBridge = bridgeGame.getRealBridge();

        for (int i = 0; i < 5; i++) {
            assertThat(bridgeGame.getCurrentLocation() == i);
            assertThat(bridgeGame.move(realBridge.get(i)));
        }
    }

    @DisplayName("현재 진행상황 저장 기능 테스트")
    @Test
    void reflectMovementTest() {
        List<String> realBridge = bridgeGame.getRealBridge();
        List<String> upper = bridgeGame.getMoveStatus().get("U");
        List<String> under = bridgeGame.getMoveStatus().get("D");

        for (int i = 0; i < 5; i++) {
            if (realBridge.get(i).equals("U")) {
                assertThat(upper.get(i).equals("O"));
            } else {
                assertThat(under.get(i).equals("O"));
            }
        }
    }

    @DisplayName("retry 기능 테스트")
    @Test
    void retryTest() {
        bridgeGame.retry();
        assertThat(bridgeGame.getCurrentLocation() == -1);
        assertThat(bridgeGame.getMoveStatus().get("U").size() == 0);
        assertThat(bridgeGame.getRestartNumber() == 2);
    }
}
