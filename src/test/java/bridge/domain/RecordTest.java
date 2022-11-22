package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.util.Lists.newArrayList;

public class RecordTest {
    private Bridge bridge;
    UsersRoute usersRoute;

    @BeforeEach
    void generateBridge() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        this.bridge = new Bridge(bridge);
        this.usersRoute = new UsersRoute();
    }

    @Test
    @DisplayName("일치하는 경우")
    void output_generation_test() {
        usersRoute.put("U");
        usersRoute.put("D");
        usersRoute.put("D");
        Assertions.assertThat(Record.getTopLane(usersRoute, bridge)).isEqualTo("[ O |   |   ]");
        Assertions.assertThat(Record.getBottomLane(usersRoute, bridge)).isEqualTo("[   | O | O ]");
    }

    @Test
    @DisplayName("두 번째에서 틀리는 경우")
    void 조기에_틀리는_경우() {
        usersRoute.put("U");
        usersRoute.put("U");
        Assertions.assertThat(Record.getTopLane(usersRoute, bridge)).isEqualTo("[ O | X ]");
        Assertions.assertThat(Record.getBottomLane(usersRoute, bridge)).isEqualTo("[   |   ]");
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
