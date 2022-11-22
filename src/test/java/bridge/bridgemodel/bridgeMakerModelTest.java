package bridge.bridgemodel;

import bridge.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class bridgeMakerModelTest {

    static final int TEST_SIZE = 3;

    @Test
    void 다리_생성_테스트1() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(TEST_SIZE);
        System.out.println(bridge);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 랜덤_세다리_생성_테스트() {
        List<String> bridgesBySize = BridgeMaker.getAllBridgeBySizeToString(TEST_SIZE);
        System.out.println(bridgesBySize);

        assertThat(bridgesBySize).contains("[D, D, D]",
                "[D, D, U]", "[D, U, D]", "[U, D, D]", "[D, U, U]",
                "[U, D, U]", "[U, U, D]", "[U, U, U]");
    }

    @Test
    void 랜덤_네다리_생성_테스트() {
        int size = TEST_SIZE + 1;
        List<String> firstRandomBridges = BridgeMaker.getAllBridgeBySizeToString(size);
        List<String> secondRandomBridges = BridgeMaker.getAllBridgeBySizeToString(size);

        List<String> result = firstRandomBridges.stream()
                .filter(target -> secondRandomBridges.stream()
                        .noneMatch(Predicate.isEqual(target)))
                .collect(Collectors.toList());

        OutputView.printMessage(result.toString());
        assertThat(result.isEmpty()).isTrue();
    }

    @Test
    void 랜덤_세다리_그리기_생성_테스트() {
        List<List<String>> randomBridges = BridgeMaker.getAllBridgeBySize(TEST_SIZE);
        List<String> allMap = getThreeBridgeMaps();
        while (!randomBridges.isEmpty()) {
            int bridgeCounts = randomBridges.size();
            List<String> bridgeBySize = randomBridges.remove(bridgeCounts-1);
            if (!allMap.contains(getMapToString(bridgeBySize))) {
                break;
            }
        }
        assertThat(randomBridges.isEmpty()).isTrue();
    }
    static String getMapToString(List<String> bridgeBySize) {
        Bridge bridge = new Bridge(bridgeBySize);
        String map = bridge.getMapToString(bridge);
        OutputView.printMap(bridge, bridge);
        return map;
    }
    static List<String> getThreeBridgeMaps() {
        return List.of("[ O | O | O ]" + GameMessage.LINE_BREAK + "[   |   |   ]",
                "[ O | O |   ]" + GameMessage.LINE_BREAK + "[   |   | O ]",
                "[ O |   | O ]" + GameMessage.LINE_BREAK + "[   | O |   ]",
                "[   | O | O ]" + GameMessage.LINE_BREAK + "[ O |   |   ]",
                "[ O |   |   ]" + GameMessage.LINE_BREAK + "[   | O | O ]",
                "[   | O |   ]" + GameMessage.LINE_BREAK + "[ O |   | O ]",
                "[   |   | O ]" + GameMessage.LINE_BREAK + "[ O | O |   ]",
                "[   |   |   ]" + GameMessage.LINE_BREAK + "[ O | O | O ]");
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
