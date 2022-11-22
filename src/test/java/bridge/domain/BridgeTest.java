package bridge.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BridgeTest {
    @Test
    void init_bridge_test() {
        Bridge.setBridge(List.of("U", "D", "D", "U"));
        assertThat(Bridge.getBridge())
                .isEqualTo(List.of(Command.UP, Command.DOWN, Command.DOWN, Command.UP));
    }
}
