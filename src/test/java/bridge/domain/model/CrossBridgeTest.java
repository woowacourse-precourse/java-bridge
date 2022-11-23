package bridge.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CrossBridgeTest {

    List<String> list = Arrays.asList("U", "D", "U", "U", "D");
    Bridge bridge = new Bridge(list);
    CrossBridge crossBridge = new CrossBridge();

    @Test
    @DisplayName("새 게임 시작할 때 초기화 하는 기능 테스트")
    void test_setNewGame() {
        int beforeTry = crossBridge.getTotalTry();
        crossBridge.setNewGame();

        assertThat(crossBridge.getSuccess()).isEqualTo("실패");
        assertThat(crossBridge.getTotalTry()).isEqualTo(beforeTry + 1);
        assertThat(crossBridge.getCrossBridgeUp()).isEqualTo(List.of());
        assertThat(crossBridge.getCrossBridgeDown()).isEqualTo(List.of());
    }

    @Test
    @DisplayName("건넌 칸 추가하는 기능 테스트")
    void test_addCrossBridge() {
        crossBridge.addCrossBridge("U");
        assertThat(crossBridge.getCrossBridgeUp()).isEqualTo(List.of("O"));
        assertThat(crossBridge.getCrossBridgeDown()).isEqualTo(List.of(" "));

        crossBridge.addCrossBridge("U");
        assertThat(crossBridge.getCrossBridgeUp()).isEqualTo(Arrays.asList("O", "X"));
        assertThat(crossBridge.getCrossBridgeDown()).isEqualTo(Arrays.asList(" ", " "));
    }
}
