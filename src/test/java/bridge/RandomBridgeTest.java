package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

class RandomBridgeTest extends CustomNsTest {
    public final RandomBridge randomBridge = new RandomBridge();

    @ParameterizedTest
    @DisplayName("다리 크기를 제대로 입력 받고 할당하는지 테스트")
    @CsvSource({
            "-1, 1, 1",
            "21, 10, 10",
            "111222333444555666777888999000, 20, 20"
    })
    void initBridgeTest(String firstCommand, String secondCommand, int bridgeSize) {

        command(firstCommand, secondCommand);
        randomBridge.initBridge();
        List<String> bridge = randomBridge.getBridge();
        assertThat(bridge.size()).isEqualTo(bridgeSize);
        assertThat(output()).contains(
                "[ERROR]",
                "다리의 길이를 입력해주세요."
        );
    }
}