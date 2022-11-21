package bridge.domain;

import bridge.domain.Bridge;
import bridge.domain.MoveResult;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {

    @Test
    void moveResult() {
        Bridge bridge = new Bridge(List.of("U", "D"));
        String upKey = "U";
        String downKey = "D";
        MoveResult trueResult = new MoveResult(upKey, true);
        MoveResult falseResult = new MoveResult(downKey, false);

        assertAll(() -> assertThat(bridge.moveResult(0, upKey)).isEqualTo(trueResult),
                () -> assertThat(bridge.moveResult(0, downKey)).isEqualTo(falseResult));
    }

}
