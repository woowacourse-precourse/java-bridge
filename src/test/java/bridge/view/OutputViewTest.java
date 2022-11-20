package bridge.view;

import static org.assertj.core.util.Lists.newArrayList;

import bridge.Application;
import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.game.BridgeGame;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class OutputViewTest extends NsTest {

    private static BridgeGame bridgeGame = new BridgeGame();
    private static List<String> bridge;
    private static final int bridgeLength = 3;

    @BeforeAll
    static void makeBridge() throws IllegalArgumentException {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeLength);
    }

    @DisplayName("printMap 출력 테스트 - 이동할 수 있는 칸을 선택한 경우")
    @Test
    void printMap_userMovedToAble_테스트() {
        OutputView.printMap(bridge, bridge);
    }

    @DisplayName("printMap 출력 테스트 - 이동할 수 없는 칸을 선택한 경우")
    @Test
    void printMap_userMovedToDisable_테스트() {
        List<String> bridge_userMove = new ArrayList<>(List.of("U", "D", "U"));
        OutputView.printMap(bridge, bridge_userMove);
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
