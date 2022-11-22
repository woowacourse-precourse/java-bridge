package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

class RandomBridgeTest extends CustomNsTest {
    public final RandomBridge randomBridge = new RandomBridge();

    @Test
    @DisplayName("다리 크기를 제대로 입력 받고 할당하는지 테스트")
    void initBridgeTest() {
        {
            command("20");
            randomBridge.initBridge();
            List<String> bridge = randomBridge.getBridge();
            assertThat(bridge.size()).isEqualTo(20);
            assertThat(output())
                    .contains("다리의 길이를 입력해주세요.");
        }

        {
            command("-1", "5");
            randomBridge.initBridge();
            List<String> bridge = randomBridge.getBridge();
            assertThat(bridge.size()).isEqualTo(5);
            assertThat(output()).contains(
                    "[ERROR]",
                    "다리의 길이를 입력해주세요."
            );
        }

        {
            command("21", "5");
            randomBridge.initBridge();
            List<String> bridge = randomBridge.getBridge();
            assertThat(bridge.size()).isEqualTo(5);
            assertThat(output()).contains(
                    "[ERROR]",
                    "다리의 길이를 입력해주세요."
            );
        }
    }
}