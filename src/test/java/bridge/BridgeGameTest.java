package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static bridge.ApplicationTest.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class BridgeGameTest {

    @DisplayName("다리를 생성하는 기능, 위 칸이면 \"U\", 아래 칸이면 \"D\"로 표현해야 한다.")
    @Test
    void makeBridgeTest() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> newBridge = bridgeMaker.makeBridge(3);
        assertThat(newBridge).containsExactly("D", "U", "U");
    }
}
