package bridge;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_이동_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        Bridge bridge = new Bridge(numberGenerator, 3);
        BridgeGame bridgeGame = new BridgeGame();
        assertThat(bridgeGame.move(bridge, "U")).isEqualTo(List.of("UO"));
    }
}
