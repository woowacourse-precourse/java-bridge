package bridge.bridgemodel;

import bridge.Bridge;
import bridge.GameMessage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class getMapTest {

    @Test
    void 일치_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));

        String map = rightBridge.getMapToString(userBridge);
        String answer = "[ O |   | O ]"
                + GameMessage.LINE_BREAK
                + "[   | O |   ]";

        System.out.println(map);
        assertThat(map).contains(answer);
    }

    @Test
    void 불일치_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "U", "U"}));

        String map = rightBridge.getMapToString(userBridge);
        String answer = "[ O | X | O ]"
                + GameMessage.LINE_BREAK
                + "[   |   |   ]";

        System.out.println(map);
        assertThat(map).contains(answer);
    }

    @Test
    void 크기_다른_불일치_기능_테스트() {
        Bridge rightBridge = new Bridge(List.of(new String[]{"U", "D", "U"}));
        Bridge userBridge = new Bridge(List.of(new String[]{"U", "U"}));

        String map = rightBridge.getMapToString(userBridge);
        String answer = "[ O | X ]"
                + GameMessage.LINE_BREAK
                + "[   |   ]";

        System.out.println(map);
        assertThat(map).contains(answer);
    }
}