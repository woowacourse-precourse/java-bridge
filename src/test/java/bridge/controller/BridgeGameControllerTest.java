package bridge.controller;

import bridge.Application;
import bridge.BridgeNumberGenerator;
import bridge.model.Bridge;
import bridge.model.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameControllerTest extends NsTest {
    private final BridgeGameController bridgeGameController = new BridgeGameController();

    @DisplayName("이동 가능한지 확인하기 테스트")
    @Test
    void isFinishedTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        Bridge bridge = new Bridge(bridgeMaker.makeBridge(3));
        Assertions.assertThat(bridgeGameController.isFinished(bridge)).isEqualTo(false);
        bridge.isMovable("U");
        Assertions.assertThat(bridgeGameController.isFinished(bridge)).isEqualTo(false);
        bridge.isMovable("D");
        Assertions.assertThat(bridgeGameController.isFinished(bridge)).isEqualTo(false);
        bridge.isMovable("D");
        Assertions.assertThat(bridgeGameController.isFinished(bridge)).isEqualTo(true);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
