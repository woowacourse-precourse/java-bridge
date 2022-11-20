package bridge;

import bridge.model.Bridge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BridgeTest {

    @DisplayName("Bridge 는 윗 칸이 정답일때 U, 아랫칸이 정답일 때 D로 나타내는 List<String> 를 매개변수로 받아 위아래 O, X로 나타나지는 다리를 생성한다.")
    @Test
    void createBridgeByValidValue() {
        Bridge bridge = new Bridge(List.of("U", "D", "U"));
        List<String> upperBridge = bridge.getUpperBridge();
        assertThat(upperBridge).containsExactly("O", "X", "O");
        List<String> lowerBridge = bridge.getLowerBridge();
        assertThat(lowerBridge).containsExactly("X", "O", "X");
    }

    @DisplayName("Bridge 의 매개변수로 U, D 가 아닌 값이 오면 예외가 발생한다.")
    @Test
    void createBridgeByInvalidValue() {
        assertThatThrownBy(() -> new Bridge(List.of("O, X, 0")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
