package bridge;

import bridge.domain.Bridge;
import bridge.domain.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class OutputViewTest {

    @DisplayName("다리 형태 생성 테스트")
    @Test
    public void printMapTest() {
        Bridge bridge = new Bridge(List.of("U", "U", "D", "D", "U"));
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("U");
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("D");
        bridge.compareWithBridge("D");
        OutputView outputView = new OutputView();
        outputView.printMap(bridge);
    }

    @DisplayName("StringBuilder capacity함수 테스트")
    @Test
    public void capacityTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.append("my");
        sb.append("name");
        Assertions.assertThat(sb.length()).isEqualTo(11);
    }

}