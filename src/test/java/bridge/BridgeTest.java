package bridge;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.model.Bridge;
import camp.nextstep.edu.missionutils.test.NsTest;

class BridgeTest extends NsTest {

    @Test
    void 프린트3개짜리_정답일때_확인() {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        bridge.printMap(2, true);
        assertThat(output()).contains(
            "[ O | O |   ]",
            "[   |   | O ]"
        );
    }
    
    @Test
    void 프린트3개짜리_오답일때_확인() {
        Bridge bridge = new Bridge(List.of("U", "U", "D"));
        bridge.printMap(2, false);
        assertThat(output()).contains(
            "[ O | O | X ]",
            "[   |   |   ]"
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[] {});
    }
}
