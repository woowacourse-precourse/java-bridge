package bridge;

import model.Bridge;
import model.BridgeSize;
import model.Moving;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {
    private Bridge bridge;
    private BridgeGame game;

    @BeforeEach
    void setUp() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = new Bridge(bridgeMaker.makeBridge(new BridgeSize("3")));
        game = new BridgeGame();
    }

    @ParameterizedTest
    @CsvSource({"U,upperBridge,O", "D,lowerBridge,X"})
    void 칸을_이동했을_때_위_아래_다리_반환(String input, String bridgeName, String result) {
        game.move(bridge, new Moving(input));
        Map<String, Bridge> bridges = game.getMovedBridge();
        assertThat(bridges.get(bridgeName).getBridge(0)).isEqualTo(result);
    }
}
