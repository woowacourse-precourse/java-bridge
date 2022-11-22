package bridge.Controller;

import bridge.Application;
import bridge.Utils.Bridge.BridgeMaker;
import bridge.Utils.Bridge.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest extends NsTest {

    private static BridgeGame bridgeGame;
    private static final int bridgeLength = 2;


    @BeforeEach
    void makeBridge() {
        bridgeGame = new BridgeGame(bridgeLength);
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList());
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(bridgeLength);
        bridgeGame.setBridgeAnswer(bridge);
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
