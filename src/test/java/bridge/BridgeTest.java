package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.Bridge;
import bridge.domain.BridgeState;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeTest extends NsTest {
    @Test
    void 다리_부분_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> tiles = bridgeMaker.makeBridge(3);
        Bridge bridge = new Bridge(tiles);
        assertThat(bridge.makeSubBridge(2)).doesNotContain(BridgeState.DOWN);
    }

    @Test
    void 같은_타일_확인_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> tiles = bridgeMaker.makeBridge(3);
        Bridge bridge = new Bridge(tiles);
        assertThat(bridge.isSameTile("U", 1)).isTrue();
    }

    @Test
    void 마지막_다리_타일_확인_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> tiles = bridgeMaker.makeBridge(3);
        Bridge bridge = new Bridge(tiles);
        boolean isLastTile = bridge.isLastTile(3);
        assertThat(isLastTile).isTrue();
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
