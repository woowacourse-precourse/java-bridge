package bridge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {
    Bridge bridge;

    @BeforeEach
    void clearBridge() {
        bridge = new Bridge(Arrays.asList("U", "D", "D"));
    }

    @DisplayName("새로운 다리를 생성한다.")
    @Test
    void makeBridge() {
        assertThat(bridge.isCompleted()).isFalse();
    }

    @DisplayName("입력 값이 맞았을 경우 true 를 반환한다.")
    @Test
    void correctBridge() {
        String movingPlace = "U";

        assertThat(bridge.isCorrect(movingPlace)).isTrue();
    }

    @DisplayName("입력 값이 틀렸을 경우 true 를 반환한다.")
    @Test
    void incorrectBridge() {
        String movingPlace = "D";

        assertThat(bridge.isCorrect(movingPlace)).isFalse();
    }

    @DisplayName("정답인 다리를 이동한다.")
    @Test
    void moveCorrectly() {
        String movingPlace = "U";

        bridge.addUpBridgeResult(movingPlace);
        bridge.addDownBridgeResult(movingPlace);

        assertThat(bridge.toString()).isEqualTo("[ O ]\n[   ]");
    }

    @DisplayName("오답인 다리를 이동한다.")
    @Test
    void moveIncorrectly() {
        String movingPlace = "D";

        bridge.addUpBridgeResult(movingPlace);
        bridge.addDownBridgeResult(movingPlace);

        assertThat(bridge.toString()).isEqualTo("[   ]\n[ X ]");
    }
}
